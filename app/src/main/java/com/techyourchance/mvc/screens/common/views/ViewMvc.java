package com.techyourchance.mvc.screens.common.views;

import android.view.View;

public interface ViewMvc {

    // This method is typically called to get the root view of the current view hierarchy.
    // It returns a View object that serves as the root from which the search will start.
    View getRootView();
}
