package com.techyourchance.mvc.screens.common.screensnavigator;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.techyourchance.mvc.screens.common.fragmentframehelper.FragmentFrameHelper;
import com.techyourchance.mvc.screens.common.fragmentframehelper.FragmentFrameWrapper;
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsFragment;
import com.techyourchance.mvc.screens.questionslist.QuestionsListFragment;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestionListFragment;
import com.techyourchance.mvc.universitydetailsfragment.UQuestionDetailsFragment;

public class ScreensNavigator {

    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }

    // Navigate to the Details Fragment
    public void toQuestionDetails(String questionId) {
        mFragmentFrameHelper.replaceFragment(QuestionDetailsFragment.newInstance(questionId));
    }

    // University
    public void toUDataDetails(String nameId) {
        mFragmentFrameHelper.replaceFragment(UQuestionDetailsFragment.newInstance(nameId));
    }

    // navigate to the questionList.
    public void toQuestionsList() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(QuestionsListFragment.newInstance()); // replace from current to questionList fragment
    }

    public void toUDataList() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(UQuestionListFragment.newInstance()); // replace from current to questionList fragment

    }

    // navigate on Action bar
    public void navigateUp() {
        mFragmentFrameHelper.navigateUp();
    }
}
