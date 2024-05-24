package com.techyourchance.mvc.universityData.uquestionlist;

import java.util.List;

public class UQuestionListResponseSchema {

    private final List<UQuestionSchema> mQuestions;

    public UQuestionListResponseSchema(List<UQuestionSchema> questions){
        mQuestions = questions;
    }

    public List<UQuestionSchema> getQuestionsd() {
        return mQuestions;
    }
}
