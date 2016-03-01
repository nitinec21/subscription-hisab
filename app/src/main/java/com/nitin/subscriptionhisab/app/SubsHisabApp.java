package com.nitin.subscriptionhisab.app;

import android.app.Application;

/**
 * Created by nitin on 01/03/16.
 */
public class SubsHisabApp extends Application {

    private static SubsHisabApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static SubsHisabApp getInstance() {
        return instance;
    }
}
