package com.example.myappben;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.myappben.CheatActivity.EXTRA_ANSWER_SHOWN;

public class MainActivity extends AppCompatActivity {
private Button mTrueButton;
private Button mFalseButton;
private ImageButton mNextButton;
private ImageButton mReturnButton;
private TextView mQuestionTextView;
private TrueFalse[] mQuestionBank=new TrueFalse[]{
        new TrueFalse(R.string.Question_1,Boolean.TRUE),
        new TrueFalse(R.string.Question_2,Boolean.FALSE),
        new TrueFalse(R.string.Question_3,Boolean.FALSE),
        new TrueFalse(R.string.Question_4,Boolean.TRUE)
};
private int mQuestionIndex=0;
private static final String tag="activity";
private static final String Keyindex="index";
private static final String isCheckAnswer="isCheckAnswer";
private Button mCheatButton;
private boolean mIsCheater=false;
private void updateQuestion()
{
    int question=mQuestionBank[mQuestionIndex].getQuestion();
    mQuestionTextView.setText(question);
}
private void checkAnswer(boolean prassed)
{
    int messageid=0;
    if (mIsCheater)
    {
        messageid=R.string.judgment_toast;
    }else {
        boolean answer = mQuestionBank[mQuestionIndex].isResult();
        if (prassed == answer) {
            messageid = R.string.correct;
        } else {
            messageid = R.string.incorrect;
        }}
        Toast.makeText(MainActivity.this, messageid, Toast.LENGTH_SHORT).show();

}

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {  System.out.println("22222222222222222222222222222222222222222222222222222222");
        if(data==null)
            return;
        mIsCheater=data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN,false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


    if(savedInstanceState!=null)
    {
        System.out.println("111111111111111111111111111111111111111111111");
        mQuestionIndex=savedInstanceState.getInt(Keyindex,0);
        if(savedInstanceState.getInt(isCheckAnswer,0)==1)
            mIsCheater=true;
        else
            mIsCheater=false;
    }

    setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        Log.d(tag,"onCreate"+mQuestionIndex);
        setContentView(R.layout.activity_main);
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view) ;
        updateQuestion();
        mQuestionTextView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.question_suggest,Toast.LENGTH_LONG).show();
            }
        });


        mTrueButton=(Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton=(Button)findViewById(R.id.False_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        System.out.println("++++++++++++++++++++++++++++++++++"+R.id.cheat_button);
        mCheatButton=(Button)findViewById(R.id.cheat_button);
        if(mCheatButton!=null)
        {
            System.out.println("==============================================");
        }
        else
        {
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        }

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start CheatActivty
                Intent i=new Intent(MainActivity.this,CheatActivity.class);
                boolean answerIsTrue=mQuestionBank[mQuestionIndex].isResult();
                i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE,answerIsTrue);
                startActivityForResult(i,0);
            }
        });
        mNextButton=(ImageButton)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestionIndex=(mQuestionIndex+1)%mQuestionBank.length;
                mIsCheater=false;
                updateQuestion();
            }
        });

        mReturnButton=(ImageButton)findViewById(R.id.back_button);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestionIndex-1>0) {
                    mQuestionIndex = (mQuestionIndex - 1) % mQuestionBank.length;

                }
                else
                {
                    mQuestionIndex=0;
                }
                mIsCheater=false;
                updateQuestion();
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(tag,"onSaveInstanceState"+mQuestionIndex);
        savedInstanceState.putInt(Keyindex,mQuestionIndex);
        savedInstanceState.putInt(isCheckAnswer, mIsCheater ? 1 : 0);
    }


    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(tag,"onStart"+mQuestionIndex);

    }
    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(tag,"onPause"+mQuestionIndex);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(tag,"onResume"+mQuestionIndex);
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(tag,"onStop"+mQuestionIndex);
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(tag,"onDestroy"+mQuestionIndex);
    }

}
