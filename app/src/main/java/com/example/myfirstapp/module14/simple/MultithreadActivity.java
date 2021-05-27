package com.example.myfirstapp.module14.simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapp.R;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multithread);

        TextView tv = findViewById(R.id.current_time_textview);
        Button b = findViewById(R.id.start_thread_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable task = () -> {
                    Calendar c = Calendar.getInstance();
                    int hours = c.get(Calendar.HOUR_OF_DAY);
                    int minutes = c.get(Calendar.MINUTE);
                    int seconds = c.get(Calendar.SECOND);
                    String time = String.format("%d:%d:%d", hours, minutes, seconds);
//                    tv.setText(time); // ERROR
                    tv.post(() -> tv.setText(time));
                };
                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.submit(task);
            }
        });
    }
}