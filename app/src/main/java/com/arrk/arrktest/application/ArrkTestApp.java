package com.arrk.arrktest.application;

import android.app.Application;

import com.arrk.arrktest.di.component.AppComponent;
import com.arrk.arrktest.di.component.DaggerAppComponent;
import com.arrk.arrktest.di.module.AppModule;


/**
 * Created by abhiholkar on 07/06/2018.
 */

public class ArrkTestApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
