package com.techyourchance.mvc.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.mvc.screens.common.dialogs.promptdialog.PromptViewMvc;
import com.techyourchance.mvc.screens.common.dialogs.promptdialog.PromptViewMvcImpl;
import com.techyourchance.mvc.screens.common.navdrawer.NavDrawerHelper;
import com.techyourchance.mvc.screens.common.navdrawer.NavDrawerViewMvc;
import com.techyourchance.mvc.screens.common.navdrawer.NavDrawerViewMvcImpl;
import com.techyourchance.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsViewMvc;
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsViewMvcImpl;
import com.techyourchance.mvc.screens.questionslist.questionslistitem.QuestionsListItemViewMvc;
import com.techyourchance.mvc.screens.questionslist.questionslistitem.QuestionsListItemViewMvcImpl;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvcImpl;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestionListViewMvc;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestionListViewMvcImpl;
import com.techyourchance.mvc.universityData.uquestionlist.uquestionlistitem.UQuestionListItemViewMvc;
import com.techyourchance.mvc.universityData.uquestionlist.uquestionlistitem.UQuestionListItemViewMvcImpl;
import com.techyourchance.mvc.universitydetailsfragment.UQuestionDetailsViewMvc;
import com.techyourchance.mvc.universitydetailsfragment.UQuestionDetailsViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;
    private final NavDrawerHelper mNavDrawerHelper;

    public ViewMvcFactory(LayoutInflater layoutInflater, NavDrawerHelper navDrawerHelper) {
        mLayoutInflater = layoutInflater;
        mNavDrawerHelper = navDrawerHelper;
    }

    public QuestionsListViewMvc getQuestionsListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListViewMvcImpl(mLayoutInflater, parent, mNavDrawerHelper, this);
    }

    // University
    public UQuestionListViewMvc getUQuestionListViewMvc(@Nullable ViewGroup parent) {
        return new UQuestionListViewMvcImpl(mLayoutInflater, parent, mNavDrawerHelper, this);
    }

    public QuestionsListItemViewMvc getQuestionsListItemViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListItemViewMvcImpl(mLayoutInflater, parent);
    }

    // university List Item
    public UQuestionListItemViewMvc getUQuestionListItemViewMvc(@Nullable ViewGroup parent) {
        return new UQuestionListItemViewMvcImpl(mLayoutInflater, parent);
    }

    public QuestionDetailsViewMvc getQuestionDetailsViewMvc(@Nullable ViewGroup parent) {
        return new QuestionDetailsViewMvcImpl(mLayoutInflater, parent, this);
    }

    // University
    public UQuestionDetailsViewMvc getUQuestionDetailsViewMvc(@Nullable ViewGroup parent) {
        return new UQuestionDetailsViewMvcImpl(mLayoutInflater, parent, this);
    }
    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(mLayoutInflater, parent);
    }

    public NavDrawerViewMvc getNavDrawerViewMvc(@Nullable ViewGroup parent) {
        return new NavDrawerViewMvcImpl(mLayoutInflater, parent);
    }

    public PromptViewMvc getPromptViewMvc(@Nullable ViewGroup parent) {
        return new PromptViewMvcImpl(mLayoutInflater, parent);
    }
}
