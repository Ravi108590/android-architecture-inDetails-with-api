package com.techyourchance.mvc.screens.common.dialogs.userdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.techyourchance.mvc.R;
import com.techyourchance.mvc.screens.common.dialogs.BaseDialog;

public class  UserDialog extends BaseDialog {

    protected static final String ARG_TITLE = "ARG_TITLE";
    protected static final String ARG_MESSAGE = "ARG_MESSAGE";
    protected static final String ARG_BUTTON_CAPTION = "ARG_BUTTON_CAPTION";

    // here all the data goes to the bundle and through the setArguments info dialog is created
    public static UserDialog newUserDialog(String title, String message, String buttonCaption) {
        UserDialog userDialog = new UserDialog();
        Bundle args = new Bundle(3);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_BUTTON_CAPTION, buttonCaption);
        userDialog.setArguments(args);
        return userDialog;
    }

    private TextView mTxtTitle;
    private ImageView mImageView;

    @NonNull
    @Override
    public final Dialog onCreateDialog(Bundle savedInstanceState) {
        if (getArguments() == null) {
            throw new IllegalStateException("arguments mustn't be null");
        }

        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.user_details);

        mTxtTitle = dialog.findViewById(R.id.user_display);
        mImageView = dialog.findViewById(R.id.imageView);

        mTxtTitle.setText(getArguments().getString(ARG_TITLE));
        String url = getArguments().getString(ARG_MESSAGE);
        Picasso.with(getContext()).load(url).into(mImageView);



        return dialog;
    }

    protected void onButtonClicked() {
        dismiss();
    }

}