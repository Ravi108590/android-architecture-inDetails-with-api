package com.techyourchance.mvc.universityData.uquestionlist;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.common.navdrawer.NavDrawerHelper;
import com.techyourchance.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.techyourchance.mvc.screens.common.views.BaseObservableViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsRecyclerAdapter;

import java.util.List;

public class UQuestionListViewMvcImpl extends BaseObservableViewMvc<UQuestionListViewMvc.Listener>
  implements UQuestionListViewMvc, UQuestionRecyclerAdapter.Listener {

    private final ToolbarViewMvc mToolbarViewMvc;
    private final NavDrawerHelper mNavDrawerHelper;

    private final Toolbar mToolbar;
    private final RecyclerView mRecyclerQuestions;
    private final UQuestionRecyclerAdapter mAdapter;
    private final ProgressBar mProgressBar;


    public UQuestionListViewMvcImpl(LayoutInflater inflater,
                                    @Nullable ViewGroup parent,
                                    NavDrawerHelper navDrawerHelper,
                                    ViewMvcFactory viewMvcFactory) {
        mNavDrawerHelper = navDrawerHelper;

        setRootView(inflater.inflate(R.layout.fragment_u_question_list, parent, false));
        mRecyclerQuestions = findViewById(R.id.u_recycler_questions);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new UQuestionRecyclerAdapter(this, viewMvcFactory);
        mRecyclerQuestions.setAdapter(mAdapter);

        mProgressBar = findViewById(R.id.Uprogress);

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        initToolbar();

    }

    private void initToolbar() {
        mToolbarViewMvc.setTitle("University List");
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHamburgerButtonAndListen(new ToolbarViewMvc.HamburgerClickListener() {
            @Override
            public void onHamburgerClicked() {
                mNavDrawerHelper.openDrawer();
            }
        });
    }

//    @Override
//    public void onUQuestionClicked(UQuestion question) {
//        for (Listener listener : getListeners()) {
//            listener
//        }
//
//    }

    @Override
    public void bindQuestions(List<UQuestion> questions) {
        mAdapter.bindQuestion(questions);

    }

    @Override
    public void showProgressIndication() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onQuestionClicked(UQuestion question) {
        for (Listener listener : getListeners()) {
            listener.onQuestionClicked(question);
        }

    }
}
