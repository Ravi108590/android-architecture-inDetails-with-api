package com.techyourchance.mvc.questions;

import com.techyourchance.mvc.networking.users.UserSchema;

//Questions Details Parameter
public class QuestionDetails {

    private final String mId;

    private final String mTitle;

    private final String mBody;

    private final UserSchema mOwner;
    public QuestionDetails(String id, String title, String body, UserSchema own) {
        mId = id;
        mTitle = title;
        mBody = body;
        // adding
        mOwner = own;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBody() {
        return mBody;
    }

    //public String getUser() {
        //return mUser;
    //}

    public UserSchema getOwner() { return mOwner; }
}
