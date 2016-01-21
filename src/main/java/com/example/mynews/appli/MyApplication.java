package com.example.mynews.appli;

import android.app.Application;


public class MyApplication extends Application{
    private static MyApplication instance=null;
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;
    }
    public static MyApplication getInstance(){
        return instance;
    }
}
