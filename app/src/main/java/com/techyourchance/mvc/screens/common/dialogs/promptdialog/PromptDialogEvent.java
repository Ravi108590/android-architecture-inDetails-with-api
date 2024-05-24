package com.techyourchance.mvc.screens.common.dialogs.promptdialog;

public class PromptDialogEvent {

    public enum Button {
        POSITIVE, NEGATIVE
    }

    private final Button mClickedButton;

    // onClick Button event positive and negative
    public PromptDialogEvent(Button clickedButton) {
        mClickedButton = clickedButton;
    }

    // onClick button getting the particular data
    public Button getClickedButton() {
        return mClickedButton;
    }
}
