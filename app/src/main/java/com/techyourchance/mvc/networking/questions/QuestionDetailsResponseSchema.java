package com.techyourchance.mvc.networking.questions;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;


// onClickQuestions details
public class QuestionDetailsResponseSchema {

    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionDetailsResponseSchema(QuestionSchema question) {
       // Returns an immutable list containing only the specified object.(at a time single fragment data)
        mQuestions = Collections.singletonList(question);
    }

    // for getting the details fragment data onClick
    public QuestionSchema getQuestion() {
        return mQuestions.get(0);
    }
}
