package com.techyourchance.mvc.screens.common.views;


// Listener is used onClick of any questions or other components of the Screens ui
public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);
}
