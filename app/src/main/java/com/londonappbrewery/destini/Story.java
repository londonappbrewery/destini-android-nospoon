package com.londonappbrewery.destini;

/**
 * Created by Mikolaj on 05/02/2018.
 */

public class Story {
    private int mText;
    private int mFirstAnswer;
    private int mSecondAnswer;

    public Story(int text, int firstAnswer, int secondAnswer) {
        mText = text;
        mFirstAnswer = firstAnswer;
        mSecondAnswer = secondAnswer;
    }

    public int getText() {
        return mText;
    }

    public void setText(int text) {
        mText = text;
    }

    public int getFirstAnswer() {
        return mFirstAnswer;
    }

    public void setFirstAnswer(int firstAnswer) {
        mFirstAnswer = firstAnswer;
    }

    public int getSecondAnswer() {
        return mSecondAnswer;
    }

    public void setSecondAnswer(int secondAnswer) {
        mSecondAnswer = secondAnswer;
    }
}
