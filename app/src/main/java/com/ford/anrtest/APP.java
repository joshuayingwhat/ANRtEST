package com.ford.anrtest;

import android.app.Application;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new ANRWatchDog().start();
    }
}
