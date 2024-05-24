package com.techyourchance.mvc.universityData.uquestionlist;

import com.techyourchance.mvc.screens.common.views.ObservableViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;

import java.util.List;

public interface UQuestionListViewMvc extends ObservableViewMvc<UQuestionListViewMvc.Listener> {

    public interface Listener {
        void onQuestionClicked(UQuestion question);
    }

    void bindQuestions(List<UQuestion> questions);

    void showProgressIndication();

    void hideProgressIndication();
}
