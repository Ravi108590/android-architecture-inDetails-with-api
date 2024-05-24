package com.techyourchance.mvc.universityData.uquestionlist;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UStackoverflowApi {

    @GET("search")
    Call<ArrayList<UQuestionSchema>> ufetchLastActiveQuestions(@Query("country") String country);

    @GET("search")
    Call<ArrayList<UQuestionSchema>> ufetchQuestionDetails(@Query("country") String country, @Query("name") String name);
}
