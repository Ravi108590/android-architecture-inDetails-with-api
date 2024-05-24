package com.techyourchance.mvc.universityData.uquestionlist;

import com.techyourchance.mvc.screens.common.dialogs.DialogsEventBus;
import com.techyourchance.mvc.screens.common.dialogs.DialogsManager;
import com.techyourchance.mvc.screens.common.dialogs.promptdialog.PromptDialogEvent;
import com.techyourchance.mvc.screens.common.screensnavigator.ScreensNavigator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UQuestionListController implements
        UQuestionListViewMvc.Listener,
        UFetchQuestionUseCase.Listener,
        DialogsEventBus.Listener {

    public enum ScreenState {
        IDLE, FETCHING_QUESTIONS, QUESTIONS_LIST_SHOWN, NETWORK_ERROR
    }

    private final UFetchQuestionUseCase mUFetchLastActiveQuestionsUseCase;
    private final ScreensNavigator mScreensNavigator;
    private final DialogsManager mDialogsManager;

    private final DialogsEventBus mUDialogsEventBus;
    private UQuestionListViewMvc mViewMvc;

    private ScreenState mScreenState = ScreenState.IDLE;

    // creating the constructor of all the above data
    public UQuestionListController(UFetchQuestionUseCase uFetchLastActiveQuestionUseCase,
                                   ScreensNavigator uScreensNavigator,
                                   DialogsManager dialogsManager,
                                   DialogsEventBus uDialogsEventBus) {

        mUFetchLastActiveQuestionsUseCase = uFetchLastActiveQuestionUseCase;
        mScreensNavigator = uScreensNavigator;
        mDialogsManager = dialogsManager;
        mUDialogsEventBus = uDialogsEventBus;
    }

    public void bindView(UQuestionListViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public SavedState getSavedState() {
        return new UQuestionListController.SavedState(mScreenState);
    }

    public void restoreSavedState(SavedState savedState) {
        mScreenState = savedState.mScreenState;
    }

    public void onStart() {
        mViewMvc.registerListener(this);
        mUFetchLastActiveQuestionsUseCase.registerListener(this);
        mUDialogsEventBus.registerListener((DialogsEventBus.Listener) this);

        if (mScreenState != ScreenState.NETWORK_ERROR) {
            fetchQuestionsAndNotify();
        }
    }
    public void onStop() {
        mViewMvc.unregisterListener(this);
        mUFetchLastActiveQuestionsUseCase.unregisterListener(this);
        mUDialogsEventBus.unregisterListener((DialogsEventBus.Listener) this);
    }
    private void fetchQuestionsAndNotify() {
        mScreenState = ScreenState.FETCHING_QUESTIONS;
        mViewMvc.showProgressIndication();
        mUFetchLastActiveQuestionsUseCase.fetchLastActiveQuestionsAndNotify();
    }
    @Override
    public void onLastActiveQuestionsFetched(ArrayList<UQuestion> questions) {

        mScreenState = ScreenState.QUESTIONS_LIST_SHOWN;
        mViewMvc.hideProgressIndication();;
        mViewMvc.bindQuestions(questions);

    }

    @Override
    public void onLastActiveQuestionsFetchFailed() {

        mScreenState = ScreenState.NETWORK_ERROR;
        mViewMvc.hideProgressIndication();
        mDialogsManager.showUseCaseErrorDialog(null);

    }

    @Override
    public void onQuestionClicked(UQuestion question) {

        mScreensNavigator.toUDataDetails(question.getName());

    }

//    @Override
//    public void onUQuestionClicked(UQuestion question) {
//        mScreensNavigator.toUDataDetails();
//    }

    @Override
    public void onDialogEvent(Object event) {
        if (event instanceof PromptDialogEvent) {
            switch (((PromptDialogEvent) event).getClickedButton()) {
                case POSITIVE: // retry and fetches the data
                    fetchQuestionsAndNotify();
                    break;
                case NEGATIVE: // close
                    mScreenState = ScreenState.IDLE;
                    break;
            }
        }
    }

    public static class SavedState implements Serializable {
        public final ScreenState mScreenState;

        public SavedState(ScreenState screenState) {
            mScreenState = screenState;
        }

    }
}
