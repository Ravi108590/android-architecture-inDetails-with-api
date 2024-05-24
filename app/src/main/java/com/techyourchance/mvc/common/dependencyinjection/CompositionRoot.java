package com.techyourchance.mvc.common.dependencyinjection;

import com.techyourchance.mvc.common.Constants;
import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.screens.common.dialogs.DialogsEventBus;
import com.techyourchance.mvc.universityData.uquestionlist.UStackoverflowApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// creating the object of the retrofit
public class CompositionRoot {

    private Retrofit mRetrofit;
    private Retrofit uRetrofit;
    private DialogsEventBus mDialogsEventBus;

    private Retrofit getRetrofit() {
        // it will fetch the data if there is not any fetched api data
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    // it will take care of api
    public StackoverflowApi getStackoverflowApi() {
        return getRetrofit().create(StackoverflowApi.class);
    }

    // University
    private Retrofit getUniversityRetrofit(){
        if (uRetrofit == null) {
            uRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.UNIVERSITY_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return uRetrofit;
    }

    public UStackoverflowApi getUniversityStackoverflowApi() {
        return getUniversityRetrofit().create(UStackoverflowApi.class);
    }

    public DialogsEventBus getDialogsEventBus() {
        if (mDialogsEventBus == null) {
            mDialogsEventBus = new DialogsEventBus();
        }
        return mDialogsEventBus;
    }
}
