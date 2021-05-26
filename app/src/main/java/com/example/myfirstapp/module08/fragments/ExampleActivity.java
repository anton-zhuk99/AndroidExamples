package com.example.myfirstapp.module08.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.R;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // if (savedInstanceState == null) => активити создано впервые
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        Button showFragmentButton = findViewById(R.id.show_fragment_button);
        FragmentContainerView fragment = findViewById(R.id.fragment);

        showFragmentButton.setOnClickListener(v -> fragment.setVisibility(View.VISIBLE));
    }
}