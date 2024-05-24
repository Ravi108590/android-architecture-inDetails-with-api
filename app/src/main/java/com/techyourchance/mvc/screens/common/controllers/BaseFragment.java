package com.techyourchance.mvc.screens.common.controllers;

import android.support.v4.app.Fragment;

import com.techyourchance.mvc.common.CustomApplication;
import com.techyourchance.mvc.common.dependencyinjection.ControllerCompositionRoot;
import com.techyourchance.mvc.screens.common.main.MainActivity;

// extends questiondetailsfragment
public class BaseFragment extends Fragment {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    // requireActivity: This method is typically used in fragments to
                    // get the current activity instance that the fragment is associated with.
                    ((MainActivity) requireActivity()).getActivityCompositionRoot()
            );
        }
        return mControllerCompositionRoot;
    }
}
