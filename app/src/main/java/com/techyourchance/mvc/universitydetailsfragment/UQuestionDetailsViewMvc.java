package com.techyourchance.mvc.universitydetailsfragment;

import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.views.ObservableViewMvc;

public interface UQuestionDetailsViewMvc extends ObservableViewMvc<UQuestionDetailsViewMvc.Listener> {

    public interface Listener {
        void onNavigateUpClicked();
        void onLocationRequestClicked();

        UQuestionDetails questionDetails();
    }

    void bindQuestion(UQuestionDetails question);

    void showProgressIndication();

    void hideProgressIndication();
}
