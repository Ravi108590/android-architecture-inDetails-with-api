package com.techyourchance.mvc.universityData.uquestionlist.uquestionlistitem;

import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.views.ObservableViewMvc;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestion;

public interface UQuestionListItemViewMvc extends ObservableViewMvc<UQuestionListItemViewMvc.Listener> {
    public interface Listener {
        void onQuestionClicked(UQuestion question);
    }

    void bindQuestion(UQuestion question);
}
