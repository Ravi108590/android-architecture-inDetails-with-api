package com.techyourchance.mvc.universitydetailsfragment;

import com.techyourchance.mvc.common.BaseObservable;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestionSchema;
import com.techyourchance.mvc.universityData.uquestionlist.UStackoverflowApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UFetchQuestionDetailsUseCase extends BaseObservable<UFetchQuestionDetailsUseCase.Listener> {



    public interface Listener {
        void onQuestionDetailsFetched(UQuestionDetails questionDetails);
        void onQuestionDetailsFetchFailed();
    }
    private final UStackoverflowApi mUStackoverflowApi;

    public UFetchQuestionDetailsUseCase(UStackoverflowApi mUStackoverflowApi) {
        this.mUStackoverflowApi = mUStackoverflowApi;
    }

    public void fetchQuestionDetailsAndNotify(String name) {
        // onClick of country
        mUStackoverflowApi.ufetchQuestionDetails("United States", name)
                .enqueue(new Callback<ArrayList<UQuestionSchema>>() {
                    @Override
                    public void onResponse(Call<ArrayList<UQuestionSchema>> call, Response<ArrayList<UQuestionSchema>> response) {
                        if (response.isSuccessful()) {
                            notifySuccess(response.body());
                        } else {
                            notifyFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<UQuestionSchema>> call, Throwable t) {
                        notifyFailure();
                    }

                });
    }
    private void notifyFailure() {
        for (Listener listener : getListeners()) {
            listener.onQuestionDetailsFetchFailed();
        }
    }

//    private void notifySuccess(UQuestionSchema questionSchema) {
//        for (Listener listener : getListeners()) { // getListener Comes from the baseObservable
//            listener.onQuestionDetailsFetched(
//                    new UQuestionDetails(
//                            questionSchema.getCountry(),
//                            questionSchema.getWebPages(),
//                            questionSchema.getAlphaTwoCode(),
//                            questionSchema.getDomains(),
//                            questionSchema.getStateProvince()
//                    ));
//        }
//    }

    private void notifySuccess(ArrayList<UQuestionSchema> questionSchemas) {
        for (UQuestionSchema questionSchema : questionSchemas) {
            for (Listener listener : getListeners()) { // getListeners comes from the baseObservable
                listener.onQuestionDetailsFetched(
                        new UQuestionDetails(
                                questionSchema.getCountry(),
                                questionSchema.getWebPages(),
                                questionSchema.getAlphaTwoCode(),
                                questionSchema.getDomains(),
                                questionSchema.getStateProvince()
                        ));
            }
        }
    }

}
