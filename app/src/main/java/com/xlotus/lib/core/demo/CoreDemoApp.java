package com.xlotus.lib.core.demo;

import android.app.Application;

import com.xlotus.lib.core.lang.ObjectStore;

public class CoreDemoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ObjectStore.setContext(this);
    }

}
