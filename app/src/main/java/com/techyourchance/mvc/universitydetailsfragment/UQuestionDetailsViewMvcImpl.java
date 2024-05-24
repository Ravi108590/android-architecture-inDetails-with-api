package com.techyourchance.mvc.universitydetailsfragment;

import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.techyourchance.mvc.screens.common.views.BaseObservableViewMvc;
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsViewMvc;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class UQuestionDetailsViewMvcImpl extends BaseObservableViewMvc<UQuestionDetailsViewMvc.Listener>
              implements UQuestionDetailsViewMvc {

    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;

    private final TextView mCountry;
    private final TextView mWebpages;

    private final TextView mAlphaTwoCode;

    private final TextView mStateProvince;
    private final TextView mDomain;

    UQuestionDetails questionDetails;

    private final ProgressBar mProgressBar;

    public UQuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_question_details_university, parent, false));
        mCountry = findViewById(R.id.ucountry);
        mAlphaTwoCode = findViewById(R.id.ualphatwocode);
        mStateProvince = findViewById(R.id.ustateprovience);
        mWebpages = findViewById(R.id.uwebpages);
        mDomain = findViewById(R.id.udomains);
        mProgressBar = findViewById(R.id.uprogress);
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        initToolbar();

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

    @Override
    public void bindQuestion(UQuestionDetails question) {
        String questionCountry = question.getCountry();
        String questionAlphaTwoCode = question.getAlphaTwoCode();
        String questionStateProvience = question.getStateProvince();
        List<String> questionWebPages =  question.getWebPages();
        List<String> questionDomains  = question.getDomains();

        this.questionDetails = question;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mCountry.setText(Html.fromHtml(questionCountry, Html.FROM_HTML_MODE_LEGACY));
            mAlphaTwoCode.setText(Html.fromHtml(questionAlphaTwoCode, Html.FROM_HTML_MODE_LEGACY));
            if (questionStateProvience!=null) {
                mStateProvince.setText(Html.fromHtml(questionStateProvience, Html.FROM_HTML_MODE_LEGACY));
            }else {
                mStateProvince.setText("null");
            }
            mWebpages.setText(Html.fromHtml(questionWebPages.toString(), Html.FROM_HTML_MODE_LEGACY));
            mDomain.setText(Html.fromHtml(questionDomains.toString(), Html.FROM_HTML_MODE_LEGACY));
        }
        else {
            mCountry.setText(Html.fromHtml(questionCountry));
            mAlphaTwoCode.setText(Html.fromHtml(questionAlphaTwoCode));
            mStateProvince.setText(Html.fromHtml(questionStateProvience));
            mWebpages.setText(Html.fromHtml(questionWebPages.toString()));
            mDomain.setText(Html.fromHtml(questionDomains.toString()));
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

    public UQuestionDetails getQuestionDetails() {
        return questionDetails;
    }
}
