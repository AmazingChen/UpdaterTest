package com.huzan.sqchen.updater;

import android.content.Context;
import android.os.AsyncTask;

public class CheckTask extends AsyncTask<Void, Void, String> {

    public CheckTask(Context ctx, UpdaterConfig config) {

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

}
