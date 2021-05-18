package com.example.myfirstapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_message_activity);

        Intent intent = getIntent();
        String inputText = intent.getStringExtra("inputText");

        double pi = intent.getDoubleExtra("pi", -1.0);

        if (pi == -1.0) {
            System.out.println("Error!");
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(inputText);
    }
}
