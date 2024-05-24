package com.techyourchance.mvc.universityData.uquestionlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.common.views.ViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsRecyclerAdapter;
import com.techyourchance.mvc.universityData.uquestionlist.uquestionlistitem.UQuestionListItemViewMvc;

import java.util.ArrayList;
import java.util.List;

public class UQuestionRecyclerAdapter extends RecyclerView.Adapter<UQuestionRecyclerAdapter.MyViewHolder>
   implements UQuestionListItemViewMvc.Listener {

    public UQuestionRecyclerAdapter(Listener mListener, ViewMvcFactory mViewMvcFactory) {
        this.mListener = mListener;
        this.mViewMvcFactory = mViewMvcFactory;
    }

    public interface Listener {

        void onQuestionClicked(UQuestion question);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final UQuestionListItemViewMvc mViewMvc;

        public MyViewHolder(UQuestionListItemViewMvc mViewMvc) {
            super(mViewMvc.getRootView());
            this.mViewMvc = mViewMvc;
        }
    }

    private final Listener mListener;
    private final ViewMvcFactory mViewMvcFactory;

    private List<UQuestion> mQuestions = new ArrayList<>();

    public void bindQuestion(List<UQuestion> questions) {
        mQuestions = new ArrayList<>(questions);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        UQuestionListItemViewMvc viewMvc = mViewMvcFactory.getUQuestionListItemViewMvc(viewGroup);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.mViewMvc.bindQuestion(mQuestions.get(position));

    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    @Override
    public void onQuestionClicked(UQuestion question) {
        mListener.onQuestionClicked(question);

    }



}
