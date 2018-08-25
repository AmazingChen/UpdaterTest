package com.huzan.sqchen.updater;

import android.content.Context;

public class UpdaterChecker {

    private UpdaterConfig config;

    public UpdaterChecker setUpdaterConfig(UpdaterConfig config) {
        if (config == null) {
            throw new RuntimeException("updater config must be defined.");
        }
            this.config = config;
        return this;
    }

    public void check(Context ctx) {
        new CheckTask(ctx, config).execute();
    }
}
