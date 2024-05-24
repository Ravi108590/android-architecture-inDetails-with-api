package com.techyourchance.mvc.universitydetailsfragment;

import com.techyourchance.mvc.networking.questions.QuestionSchema;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestionSchema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UQuestionDetailsResponseSchema {

    private final ArrayList<UQuestionSchema> mQuestions;

    public UQuestionDetailsResponseSchema(UQuestionSchema question) {
        // Returns an immutable list containing only the specified object.(at a time single fragment data)
        mQuestions = (ArrayList<UQuestionSchema>) Collections.singletonList(question);
    }

    // for getting the details fragment data onClick
    public UQuestionSchema getQuestion() {
        return mQuestions.get(0);
    }
}
