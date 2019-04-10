package com.cmcm.myapplication;

import android.app.Application;

import com.cmcm.myapplication.db.AppDatabase;
import com.facebook.stetho.Stetho;

public class MobileApp extends Application {

    public static MobileApp sMobileApp;

    private AppExecutors mAppExecutors;

    public MobileApp() {
        sMobileApp = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();

        Stetho.initializeWithDefaults(this);
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }
}