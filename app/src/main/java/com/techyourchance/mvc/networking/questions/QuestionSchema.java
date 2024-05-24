package com.techyourchance.mvc.networking.questions;

import com.google.gson.annotations.SerializedName;
import com.techyourchance.mvc.networking.users.UserSchema;

import java.util.List;

public class QuestionSchema {

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("question_id")
    private final String mId;

    @SerializedName("body")
    private final String mBody;

    @SerializedName("owner")
    private final UserSchema mOwner;

    // for University


    public QuestionSchema(String title, String id, String body, UserSchema owner) {
        mTitle = title;
        mId = id;
        mBody = body;
        mOwner = owner;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }

    public String getBody() {
        return mBody;
    }

    // for UserSchema Data
    public UserSchema getOwner() {
        return mOwner;
    }



}
