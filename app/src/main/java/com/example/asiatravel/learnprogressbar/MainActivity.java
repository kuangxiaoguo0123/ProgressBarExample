package com.example.asiatravel.learnprogressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.asiatravel.learnprogressbar.view.HorizontalProgressbarWithProgress;
import com.example.asiatravel.learnprogressbar.view.RoundProgressbarWithProgress;

public class MainActivity extends AppCompatActivity {

    private static final int HORIZONTAL_WHAT = 0;
    private HorizontalProgressbarWithProgress progressBar;
    private RoundProgressbarWithProgress roundProgressBar;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int progress = progressBar.getProgress();
            int nextProgress = ++progress;
            progressBar.setProgress(nextProgress);
            roundProgressBar.setProgress(nextProgress);
            mHandler.sendEmptyMessageDelayed(HORIZONTAL_WHAT, 100);
            if (progress >= 100) {
                mHandler.removeMessages(HORIZONTAL_WHAT);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (HorizontalProgressbarWithProgress) findViewById(R.id.progressBar);
        roundProgressBar = (RoundProgressbarWithProgress) findViewById(R.id.round_progressBar);
        mHandler.sendEmptyMessage(HORIZONTAL_WHAT);
    }
}
