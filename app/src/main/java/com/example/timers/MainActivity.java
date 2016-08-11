package com.example.timers;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private ProgressBar mProgressBar;
    private TextView mTextView;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.a_main_progress);
        mTextView = (TextView) findViewById(R.id.coun_txt);

    }

    public void doMagic(View view) {


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + Thread.currentThread());

                handler.postDelayed(this, 1000);
                mTextView.setText(String.valueOf(counter++));

                mProgressBar.setMax(200);
                mProgressBar.setProgress(counter);
                mProgressBar.setVisibility(View.VISIBLE);
/*
                if(counter % 2 == 0)
                    mProgressBar.setVisibility(View.INVISIBLE);
                 else mProgressBar.setVisibility(View.VISIBLE);
*/

            }
        }, 1000);
    }
}
