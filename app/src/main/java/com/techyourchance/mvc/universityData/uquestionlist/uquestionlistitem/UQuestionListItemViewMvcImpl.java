package com.techyourchance.mvc.universityData.uquestionlist.uquestionlistitem;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.screens.common.views.BaseObservableViewMvc;
import com.techyourchance.mvc.universityData.uquestionlist.UQuestion;

public class UQuestionListItemViewMvcImpl extends BaseObservableViewMvc<UQuestionListItemViewMvc.Listener>
        implements UQuestionListItemViewMvc {

    private final TextView mTxtTitle1;

    private UQuestion mQuestion;
    public UQuestionListItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent){
        setRootView(inflater.inflate(R.layout.uquestion_list_item, parent, false));

        mTxtTitle1 = findViewById(R.id.txt_title);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });

    }

    @Override
    public void bindQuestion(UQuestion question) {
        mQuestion = question;
        // setting the title of the question
        mTxtTitle1.setText(question.getName());
    }
}
