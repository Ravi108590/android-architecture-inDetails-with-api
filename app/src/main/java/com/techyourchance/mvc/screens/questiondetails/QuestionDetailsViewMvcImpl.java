package com.techyourchance.mvc.screens.questiondetails;

import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.common.dialogs.userdialog.UserDialog;
import com.techyourchance.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.techyourchance.mvc.screens.common.views.BaseObservableViewMvc;


public class QuestionDetailsViewMvcImpl extends BaseObservableViewMvc<QuestionDetailsViewMvc.Listener>
        implements QuestionDetailsViewMvc {


    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;

    private final TextView mTxtQuestionTitle;
    private final TextView mTxtQuestionBody;

    QuestionDetails questionDetails;
    private final TextView mTextQuestionUser; // for user
//    private final ImageView mImageView;
    private final ProgressBar mProgressBar;

    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {

        setRootView(inflater.inflate(R.layout.layout_question_details, parent, false));

        mTxtQuestionTitle = findViewById(R.id.txt_question_title);
        mTxtQuestionBody = findViewById(R.id.txt_question_body);
        mProgressBar = findViewById(R.id.progress);
        mToolbar = findViewById(R.id.toolbar);
        mTextQuestionUser = findViewById(R.id.txt_question_user); // user
//        mImageView        = findViewById(R.id.)
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);

        initToolbar();
        mTextQuestionUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onUserDialog();
            }
        });
    }

    // trying to access the userData
    private void onUserDialog() {
        for (Listener listener : getListeners()) {
            String name = getQuestionDetails().getOwner().getUserDisplayName();
            String url = getQuestionDetails().getOwner().getUserAvatarUrl();
            listener.userInfoDialog(name, url);
        }
    }

    private void initToolbar() {
        mToolbar.addView(mToolbarViewMvc.getRootView());

        // for menu question details
        mToolbarViewMvc.setTitle(getString(R.string.question_details_screen_title));

        mToolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClicked() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUpClicked();
                }
            }
        });

        mToolbarViewMvc.enableLocationRequestButtonAndListen(new ToolbarViewMvc.LocationRequestListener() {
            @Override
            public void onLocationRequestClicked() {
                for (Listener listener : getListeners()) {
                    listener.onLocationRequestClicked();
                }
            }
        });
    }

    // binds the question details to the fragment
    @Override
    public void bindQuestion(QuestionDetails question) {
        String questionTitle = question.getTitle();
        String questionBody = question.getBody();
        String questionUser = question.getOwner().getUserDisplayName(); // user

        this.questionDetails = question;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mTxtQuestionTitle.setText(Html.fromHtml(questionTitle, Html.FROM_HTML_MODE_LEGACY));
            mTxtQuestionBody.setText(Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY));
            mTextQuestionUser.setText(Html.fromHtml(questionUser, Html.FROM_HTML_MODE_LEGACY)); // user
        } else {
            mTxtQuestionTitle.setText(Html.fromHtml(questionTitle));
            mTxtQuestionBody.setText(Html.fromHtml(questionBody));
            mTextQuestionUser.setText(Html.fromHtml(questionUser)); // user
        }
    }


    @Override
    public void showProgressIndication() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
        mProgressBar.setVisibility(View.GONE);
    }

    public QuestionDetails getQuestionDetails() {
        return questionDetails;
    }
}
