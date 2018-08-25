package com.huzan.sqchen.updater.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ApkUtils {


    public static void installAPk(Context context, File apkFile) {
        Log.d(Constants.TAG, "installAPK() excuted.");
        Intent installAPKIntent = getApkInstallIntent(context, apkFile);
        context.startActivity(installAPKIntent);

    }


    public static Intent getApkInstallIntent(Context context, File apkFile) {
        Log.d(Constants.TAG, "getApkInStallIntent() excuted. apkFile = " + apkFile);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName()
                    + ".update.provider", apkFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        } else {
            Uri uri = getApkUri(apkFile);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        }
        return intent;
    }

    /**
     * 静默安装，需要系统授权
     *
     * @param apkPath
     * @return
     */
    public static boolean installSilent(String apkPath) {
        Log.d(Constants.TAG, "installSilent() excuted. apkPath = " + apkPath);
        boolean result = false;
        DataOutputStream dataOutputStream = null;
        BufferedReader errorStream = null;
        try {
            // 申请su权限
            Process process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());
            // 执行pm install命令
            String command = "pm install -r " + apkPath + "\n";
            dataOutputStream.write(command.getBytes(Charset.forName("utf-8")));
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
            errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String msg = "";
            String line;
            // 读取命令的执行结果
            while ((line = errorStream.readLine()) != null) {
                msg += line;
            }
            Log.d(Constants.TAG, "install msg is " + msg);
            // 如果执行结果中包含Failure字样就认为是安装失败，否则就认为安装成功
            if (!msg.contains("Failure")) {
                result = true;
                Log.i(Constants.TAG, "success to install sliently");
            } else {
                Log.i(Constants.TAG, "error msg contains 'Failure', fail to install app sliently.");
            }
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage(), e);
        } finally {
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (IOException e) {
                Log.e(Constants.TAG, e.getMessage(), e);
            }
        }
        return result;
    }

    private static Uri getApkUri(File apkFile) {
        Log.d(Constants.TAG, apkFile.toString());
        //如果没有设置 SDCard 写权限，或者没有 SDCard,apk 文件保存在内存中，需要授予权限才能安装
        try {
            String[] command = {"chmod", "777", apkFile.toString()};
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        Uri uri = Uri.fromFile(apkFile);
        Log.d(Constants.TAG, uri.toString());
        return uri;
    }

}
