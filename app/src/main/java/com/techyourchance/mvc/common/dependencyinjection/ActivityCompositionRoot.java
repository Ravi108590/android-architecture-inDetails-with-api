package com.techyourchance.mvc.common.dependencyinjection;

import android.support.v4.app.FragmentActivity;

import com.techyourchance.mvc.common.permissions.PermissionsHelper;
import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.screens.common.dialogs.DialogsEventBus;
import com.techyourchance.mvc.universityData.uquestionlist.UStackoverflowApi;

public class ActivityCompositionRoot {

    private final CompositionRoot mCompositionRoot; // for retrofit objects

    private final FragmentActivity mActivity;

    private PermissionsHelper mPermissionsHelper; // for different Permissions

    // Constructor
    public ActivityCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public FragmentActivity getActivity() {
        return mActivity;
    }

    public StackoverflowApi getStackoverflowApi() {
        return mCompositionRoot.getStackoverflowApi();
    }

    // University
    public UStackoverflowApi getStackoverflowApiData() {
        return mCompositionRoot.getUniversityStackoverflowApi();
    }

    // it's handle the publisher and subscriber
    public DialogsEventBus getDialogsEventBus() {
        return mCompositionRoot.getDialogsEventBus();
    }

    public PermissionsHelper getPermissionsHelper() {
        if (mPermissionsHelper == null) {
            mPermissionsHelper = new PermissionsHelper(getActivity());
        }
        return mPermissionsHelper;
    }

    // university function

}
