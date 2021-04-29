package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_message_activity);

        Intent intent = getIntent();
        String inputText = intent.getStringExtra("inputText");

        TextView textView = findViewById(R.id.textView);
        textView.setText(inputText);
    }
}
