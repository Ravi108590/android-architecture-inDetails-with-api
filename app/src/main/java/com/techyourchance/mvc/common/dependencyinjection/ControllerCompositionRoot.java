package com.techyourchance.mvc.common.dependencyinjection;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.techyourchance.mvc.common.permissions.PermissionsHelper;
import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.questions.FetchLastActiveQuestionsUseCase;
import com.techyourchance.mvc.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.mvc.screens.common.controllers.BackPressDispatcher;
import com.techyourchance.mvc.screens.common.dialogs.DialogsEventBus;
import com.techyourchance.mvc.screens.common.dialogs.DialogsManager;
import com.techyourchance.mvc.screens.common.fragmentframehelper.FragmentFrameHelper;
import com.techyourchance.mvc.screens.common.fragmentframehelper.FragmentFrameWrapper;
import com.techyourchance.mvc.screens.common.navdrawer.NavDrawerHelper;
import com.techyourchance.mvc.screens.common.toastshelper.ToastsHelper;
import com.techyourchance.mvc.screens.common.screensnavigator.ScreensNavigator;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.questionslist.QuestionsListController;
import com.techyourchance.mvc.universityData.uquestionlist.UFetchQuestionUseCase;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestionListController;
import com.techyourchance.mvc.universityData.uquestionlist.UStackoverflowApi;
import com.techyourchance.mvc.universitydetailsfragment.UFetchQuestionDetailsUseCase;

public class ControllerCompositionRoot {

    private final ActivityCompositionRoot mActivityCompositionRoot; // for the permissions

    public ControllerCompositionRoot(ActivityCompositionRoot activityCompositionRoot) {
        mActivityCompositionRoot = activityCompositionRoot;
    }

    private FragmentActivity getActivity() {
        return mActivityCompositionRoot.getActivity();
    }

    private Context getContext() {
        return getActivity();
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private StackoverflowApi getStackoverflowApi() {
        return mActivityCompositionRoot.getStackoverflowApi();
    }

    // University
    private UStackoverflowApi getStackoverflowApiData() {
        return mActivityCompositionRoot.getStackoverflowApiData();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater(), getNavDrawerHelper());
    }

    private NavDrawerHelper getNavDrawerHelper() {
        return (NavDrawerHelper) getActivity();
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
    }

    // University
    public UFetchQuestionDetailsUseCase getUFetchQuestionDetailsUseCase() {
        return new UFetchQuestionDetailsUseCase(getStackoverflowApiData());
    }

    public FetchLastActiveQuestionsUseCase getFetchLastActiveQuestionsUseCase() {
        return new FetchLastActiveQuestionsUseCase(getStackoverflowApi());
    }

    // University
    public UFetchQuestionUseCase getUFetchLastActiveQuestionUseCase() {
        return new UFetchQuestionUseCase(getStackoverflowApiData());
    }

    public QuestionsListController getQuestionsListController() {
        return new QuestionsListController(
                getFetchLastActiveQuestionsUseCase(),
                getScreensNavigator(),
                getDialogsManager(),
                getDialogsEventBus()
        );
    }

    // University

    public UQuestionListController getUQuestionListController() {
        return new UQuestionListController(
                getUFetchLastActiveQuestionUseCase(),
                getScreensNavigator(),
                getDialogsManager(),
                getDialogsEventBus()
        );
    }

    public ToastsHelper getToastsHelper() {
        return new ToastsHelper(getContext());
    }

    // on Frame layout(in details page) shows different fragment
    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentFrameHelper());
    }

    // University

    private FragmentFrameHelper getFragmentFrameHelper() {
        return new FragmentFrameHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager());
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper) getActivity();
    }

    public BackPressDispatcher getBackPressDispatcher() {
        return (BackPressDispatcher) getActivity();
    }

    public DialogsManager getDialogsManager() {
        return new DialogsManager(getContext(), getFragmentManager());
    }

    public DialogsEventBus getDialogsEventBus() {
        return mActivityCompositionRoot.getDialogsEventBus();
    }

    // University
    public PermissionsHelper getPermissionsHelper() {
        return mActivityCompositionRoot.getPermissionsHelper();
    }

    // University Controller

//    public PermissionsHelper getUDialogsEventBus() {
//        return mActivityCompositionRoot.getPermissionsHelper();
//
//    }


}
