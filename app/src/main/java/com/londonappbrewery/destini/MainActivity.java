package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private int mPosition;
    private TextView mStoryText;
    private Button mButtonTop;
    private Button mButtonBottom;
    private Story[] mStories = {
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Story(R.string.T4_End, 0, 0),
            new Story(R.string.T5_End, 0, 0),
            new Story(R.string.T6_End, 0, 0),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mPosition = savedInstanceState.getInt("position");
        } else {
            mPosition = 0;
        }

        mStoryText = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        proceed();

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPosition == 0 || mPosition == 1) {
                    mPosition = 2;
                } else if (mPosition == 2) {
                    mPosition = 5;
                }

                proceed();
            }
        });

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPosition == 0) {
                    mPosition = 1;
                } else if (mPosition == 1) {
                    mPosition = 3;
                } else if (mPosition == 2) {
                    mPosition = 4;
                }

                proceed();
            }
        });
    }

    private void proceed() {
        Story nextStory = mStories[mPosition];

        mStoryText.setText(nextStory.getText());

        if (nextStory.getFirstAnswer() != 0) {
            mButtonTop.setText(nextStory.getFirstAnswer());
        }
        else {
            mButtonTop.setText("");
        }

        if (nextStory.getSecondAnswer() != 0) {
            mButtonBottom.setText(nextStory.getSecondAnswer());
        } else {
            mButtonBottom.setText("");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("position", mPosition);
    }
}
