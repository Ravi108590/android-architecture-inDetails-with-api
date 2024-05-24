package com.techyourchance.mvc.screens.common.navdrawer;

import android.widget.FrameLayout;

import com.techyourchance.mvc.screens.common.views.ObservableViewMvc;

public interface NavDrawerViewMvc extends ObservableViewMvc<NavDrawerViewMvc.Listener> {

    interface Listener {

        void onQuestionsListClicked();
        void onUniversityClicked();
    }

    FrameLayout getFragmentFrame();

    boolean isDrawerOpen();
    void openDrawer();
    void closeDrawer();

}
