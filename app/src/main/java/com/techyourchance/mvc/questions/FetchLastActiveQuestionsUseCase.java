package com.techyourchance.mvc.questions;

import android.util.Log;

import com.techyourchance.mvc.common.BaseObservable;
import com.techyourchance.mvc.common.Constants;
import com.techyourchance.mvc.networking.questions.QuestionSchema;
import com.techyourchance.mvc.networking.questions.QuestionsListResponseSchema;
import com.techyourchance.mvc.networking.StackoverflowApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FetchLastActiveQuestionsUseCase extends BaseObservable<FetchLastActiveQuestionsUseCase.Listener> {

    public interface Listener {
        void onLastActiveQuestionsFetched(List<Question> questions);
        void onLastActiveQuestionsFetchFailed();
    }

    private final StackoverflowApi mStackoverflowApi;

    public FetchLastActiveQuestionsUseCase(StackoverflowApi stackoverflowApi) {
        mStackoverflowApi = stackoverflowApi;
    }

    // fetching the questions into the list fragment
    public void fetchLastActiveQuestionsAndNotify() {
        mStackoverflowApi.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(new Callback<QuestionsListResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                        if (response.isSuccessful()) {
                            Log.d("QData", "Succesfully questionFetched............");
                            // getQuestions() implemented into the detailsResponse
                            notifySuccess(response.body().getQuestions());
                        } else {
                            notifyFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                        notifyFailure();
                        Log.d("data", "QData failed getting..........");
                    }
                } );
    }

    private void notifyFailure() {
        for (Listener listener : getListeners()) {
            listener.onLastActiveQuestionsFetchFailed();
        }
    }

    private void notifySuccess(List<QuestionSchema> questionSchemas) {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for (QuestionSchema questionSchema : questionSchemas) {
            questions.add(new Question(questionSchema.getId(), questionSchema.getTitle()));
        }
        for (Listener listener : getListeners()) {
            listener.onLastActiveQuestionsFetched(questions);
        }
    }
}
