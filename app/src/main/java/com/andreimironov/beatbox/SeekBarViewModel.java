package com.andreimironov.beatbox;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SeekBarViewModel extends BaseObservable {
    private BeatBox mBeatBox;
    private int mProgress;

    public SeekBarViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
        mProgress = 50;
    }

    @Bindable
    public int getProgress() {
        return mProgress;
    }

    @Bindable
    public String getTitle() {
        return "Playback Speed: " + mProgress + "%";
    }

    public void setProgress(int progress) {
        mProgress = progress;
        mBeatBox.setRate(0.5f + 0.015f * progress);
        notifyChange();
    }
}
