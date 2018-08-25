package com.huzan.sqchen.updater;

import com.huzan.sqchen.updater.constants.UpdateType;

public class UpdaterConfig {

    private UpdateType type;

    private String url;

    private ApkInfo apkInfo;

    /** 网络类型 */
    private int networkType;

    /** 是否允许漫游网络环境中执行下载操作 */
    private boolean allowedOverRoaming;

    /** 是否允许计量式的网络连接执行下载操作 */
    private boolean allowedOverMetered;

    private UpdaterConfig(Builder builder) {
        type = builder.type;
        url = builder.url;
        apkInfo = builder.apkInfo;
        networkType = builder.networkType;
        allowedOverRoaming = builder.allowedOverRoaming;
        allowedOverMetered = builder.allowedOverMetered;
    }


    public static final class Builder {
        private UpdateType type;
        private String url;
        private ApkInfo apkInfo;
        private int networkType;
        private boolean allowedOverRoaming;
        private boolean allowedOverMetered;

        public Builder() {
        }

        public Builder type(UpdateType type) {
            this.type = type;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder apkInfo(ApkInfo apkInfo) {
            this.apkInfo = apkInfo;
            return this;
        }

        public Builder networkType(int flags) {
            this.networkType = flags;
            return this;
        }

        public Builder allowedOverRoaming(boolean allowed) {
            this.allowedOverRoaming = allowed;
            return this;
        }

        public Builder allowedOverMetered(boolean allowed) {
            this.allowedOverMetered = allowed;
            return this;
        }

        public UpdaterConfig build() {
            return new UpdaterConfig(this);
        }
    }
}
