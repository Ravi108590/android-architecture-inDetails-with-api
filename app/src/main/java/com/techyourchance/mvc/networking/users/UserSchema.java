package com.techyourchance.mvc.networking.users;

import com.google.gson.annotations.SerializedName;

// It's used into the questions schema for the details of the owner of the questions
public class UserSchema {

    @SerializedName("display_name")
    private final String mUserDisplayName;

    @SerializedName("profile_image")
    private final String mUserAvatarUrl;

    public UserSchema(String userDisplayName, String userAvatarUrl) {
        mUserDisplayName = userDisplayName;
        mUserAvatarUrl = userAvatarUrl;
    }

    public String getUserAvatarUrl() {return mUserAvatarUrl;}

    public String getUserDisplayName() {return mUserDisplayName;}

}
