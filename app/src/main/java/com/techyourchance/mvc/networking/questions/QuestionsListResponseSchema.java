package com.techyourchance.mvc.networking.questions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// ListOfQuestions
public class QuestionsListResponseSchema {

    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionsListResponseSchema(List<QuestionSchema> questions) {
        mQuestions = questions;
    }

    public List<QuestionSchema> getQuestions() {
        return mQuestions;
    }
}
