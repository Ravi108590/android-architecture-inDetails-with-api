package com.techyourchance.mvc.universityData.uquestionlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.screens.common.controllers.BaseFragment;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;

public class UQuestionListFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new UQuestionListFragment();
    }

    private static final String SAVED_STATE_CONTROLLER_U = "SAVED_STATE_CONTROLLER";

    private UQuestionListController mQuestionListController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        UQuestionListViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getUQuestionListViewMvc(container);

        mQuestionListController = getCompositionRoot().getUQuestionListController();
        if (savedInstanceState != null) {
            restoreControllerState(savedInstanceState);
        }
        mQuestionListController.bindView(viewMvc);
        return viewMvc.getRootView();
    }

        private void restoreControllerState(Bundle savedInstanceState){
            mQuestionListController.restoreSavedState(
                    (UQuestionListController.SavedState)
                            savedInstanceState.getParcelable(SAVED_STATE_CONTROLLER_U)
            );
        }

    @Override
    public void onStart() {
        super.onStart();
        mQuestionListController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mQuestionListController.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SAVED_STATE_CONTROLLER_U, mQuestionListController.getSavedState());
    }
    }
