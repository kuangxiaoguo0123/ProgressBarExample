# LearnProgressBar
Android custom horizontal  and circle progressBar

## Screenshots
![](https://github.com/kuangxiaoguo0123/LearnProgressBar/raw/master/screenshots/progress.gif)

## attrs定义
````
<resources>

    <attr name="progress_unreach_color" format="color" />
    <attr name="progress_unreach_height" format="dimension" />
    <attr name="progress_reach_color" format="color" />
    <attr name="progress_reach_height" format="dimension" />
    <attr name="progress_text_color" format="color" />
    <attr name="progress_text_size" format="dimension" />
    <attr name="progress_text_offset" format="dimension" />

    <declare-styleable name="HorizontalProgressbarWithProgress">
        <attr name="progress_unreach_color" />
        <attr name="progress_unreach_height" />
        <attr name="progress_reach_color" />
        <attr name="progress_reach_height" />
        <attr name="progress_text_color" />
        <attr name="progress_text_size" />
        <attr name="progress_text_offset" />
    </declare-styleable>

    <declare-styleable name="RoundProgressbarWithProgress">
        <attr name="radius" format="dimension" />
    </declare-styleable>
</resources>
````
## xlm示例
````
<com.example.asiatravel.learnprogressbar.view.HorizontalProgressbarWithProgress
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:progress="20"
            app:progress_reach_color="#55bfb7"
            app:progress_reach_height="6dp"
            app:progress_text_color="#f00"
            app:progress_unreach_color="#fd7530"
            app:progress_unreach_height="5dp" />
````
## 效果实现
> **MainActivity.java**

````
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
````
