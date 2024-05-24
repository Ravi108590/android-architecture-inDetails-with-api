package com.techyourchance.mvc.universityData.uquestionlist;

import android.util.Log;

import com.techyourchance.mvc.common.BaseObservable;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UFetchQuestionUseCase extends BaseObservable<UFetchQuestionUseCase.Listener> {



    public interface Listener {
        void onLastActiveQuestionsFetched(ArrayList<UQuestion> questions);
        void onLastActiveQuestionsFetchFailed();
    }

    private final UStackoverflowApi mUStackoverflowApi;

    // Created constructor
    public UFetchQuestionUseCase(UStackoverflowApi mUStackoverflowApi) {
        this.mUStackoverflowApi = mUStackoverflowApi;
    }

    // fetching the questions into the list fragment

    public void fetchLastActiveQuestionsAndNotify() {
        mUStackoverflowApi.ufetchLastActiveQuestions("United States")
                .enqueue(new Callback<ArrayList<UQuestionSchema>>() {
                    @Override
                    public void onResponse(Call<ArrayList<UQuestionSchema>> call, Response<ArrayList<UQuestionSchema>> response) {
                        if (response.isSuccessful()) {
                            Log.d("TAG", "onResponse: "+response.body());
                            // getQuestions() implemented into the detailsResponse
                            notifySuccess(response.body());

                            Log.d("Data", "Successfully fetched the University Data....");
                        } else {
                            Log.d("TAG", "onResponse: "+response.body());
                            notifyFailure();
                            Log.d("Data", "Failed to fetch University Data");
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<UQuestionSchema>> call, Throwable t) {
                        notifyFailure();
                        Log.d("Data", "Failed to fetch outer University Data");
                    }
                });
    }

    private void notifyFailure() {
        for (Listener listener : getListeners()) {
            Log.d("failed", "failedDataFetching.............");
            listener.onLastActiveQuestionsFetchFailed();
        }
    }

    private void notifySuccess(ArrayList<UQuestionSchema> questionSchemas) {
        ArrayList<UQuestion> questions = new ArrayList<>();
        for (UQuestionSchema questionSchema : questionSchemas) {
            questions.add(new UQuestion(questionSchema.getName()));
            Log.d("nameData", "Data:" +questionSchema.getName());
        }
        for (Listener listener : getListeners()) {
            listener.onLastActiveQuestionsFetched(questions);
        }
    }
}
