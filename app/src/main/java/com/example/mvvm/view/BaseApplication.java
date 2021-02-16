package com.example.mvvm.view;

import android.app.Application;

import com.example.mvvm.di.component.DaggerMainComponent;
import com.example.mvvm.di.component.MainComponent;


public class BaseApplication extends Application {

    private MainComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerMainComponent.create();


    }

    public MainComponent getAppComponent() {
        return appComponent;
    }
}