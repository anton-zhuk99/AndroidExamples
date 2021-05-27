package com.example.myfirstapp.module14.multithreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myfirstapp.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadsActivity extends AppCompatActivity {

    private TextView clickTv;
    private Button clickB;
    private Button launchPb;
    private ProgressBar pb;

    private int pbStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_threads);

        clickTv = findViewById(R.id.clickIndicatorTextView);
        clickB = findViewById(R.id.clickButton);
        launchPb = findViewById(R.id.launchProgressBarButton);
        pb = findViewById(R.id.progressBar);

        clickB.setOnClickListener(v -> {
            int value = Integer.parseInt(clickTv.getText().toString());
            clickTv.setText(String.valueOf(++value));
        });

        launchPb.setOnClickListener(v -> {
            Runnable task = () -> {
                for (; pbStatus <= 100; ++pbStatus) {
                    try {
                        pb.post(() -> pb.setProgress(pbStatus));
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(task);

            executor.shutdown();
        });
    }
}