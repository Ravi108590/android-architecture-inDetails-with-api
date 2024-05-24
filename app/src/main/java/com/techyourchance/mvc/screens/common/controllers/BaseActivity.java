package com.techyourchance.mvc.screens.common.controllers;

import android.support.v7.app.AppCompatActivity;

import com.techyourchance.mvc.common.CustomApplication;
import com.techyourchance.mvc.common.dependencyinjection.ActivityCompositionRoot;
import com.techyourchance.mvc.common.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ActivityCompositionRoot mActivityCompositionRoot; // for the permissions of dialogs and internet for api data fetching
    private ControllerCompositionRoot mControllerCompositionRoot; // different managers , helper and EventBus

    public ActivityCompositionRoot getActivityCompositionRoot() {
        //checks whether the mActivityCompositionRoot has already been initialized.
        if (mActivityCompositionRoot == null) { // Create a new instance if it is null
            mActivityCompositionRoot = new ActivityCompositionRoot(
                    // getApplication(): Return the application instance that owns this activity
                    ((CustomApplication) getApplication()).getCompositionRoot()
                    , this
            );
        }
        return mActivityCompositionRoot;
    }

    // it sets the data from api through retrofit
    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            // here we are having instance of getActivityCompositionRoot()
            mControllerCompositionRoot = new ControllerCompositionRoot(getActivityCompositionRoot());
        }
        return mControllerCompositionRoot;
    }
}
