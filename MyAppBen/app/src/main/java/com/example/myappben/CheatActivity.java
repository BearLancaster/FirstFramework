package com.example.myappben;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
    public static final String EXTRA_ANSWER_IS_TRUE="com.bignerdranch.android.geoquiz.answer_is_true";
    private boolean mAnswerIsTrue;
    private Button mShowAnswer;
    public static final String EXTRA_ANSWER_SHOWN="com.bignerdranch.android.geoquiz.answer_shown";
    private static final String isCheckAnswer="isCheckAnswer";

    private TextView mAnswerTextView;
    private void setAnswerShowResult(boolean IsKnown)
    {
        Intent data=new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,IsKnown);
        setResult(RESULT_OK,data);
    }


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        if(saveInstanceState!=null)
        {
            System.out.println("111111111111111111111111111111111111111111111");

            if(saveInstanceState.getInt(isCheckAnswer,0)==1)
                setAnswerShowResult(true);
            else
                setAnswerShowResult(false);
        }

       // setAnswerShowResult(false);
        super.onCreate(saveInstanceState);
        setContentView(R.layout.cheatactivity);
        mAnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mAnswerTextView=(TextView)findViewById(R.id.answerTextView);
        mShowAnswer=(Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK);
                if(mAnswerIsTrue)
                {
                    mAnswerTextView.setText(R.string.true_button);

                }
                else
                {
                    mAnswerTextView.setText(R.string.False_button);
                }
                setAnswerShowResult(true);
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(isCheckAnswer, mAnswerIsTrue ? 1 : 0);
    }
}
