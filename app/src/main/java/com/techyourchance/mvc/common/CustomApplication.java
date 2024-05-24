package com.techyourchance.mvc.common;

import android.app.Application;

import com.techyourchance.mvc.common.dependencyinjection.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot mCompositionRoot; // question

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }



    // here stores the retrofit object into the mCompositionRoot and return into the get function
    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
