package com.example.myfirstapp.module07.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.example.myfirstapp.R;

public class DialogActivity extends AppCompatActivity {

    private Dialog dialog;
    private Button showDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        dialog = new Dialog(this);
        showDialogButton = findViewById(R.id.show_dialog_button);

        dialog.setTitle("My dialog title");
        dialog.setContentView(R.layout.dialog_view);

        showDialogButton.setOnClickListener(v -> dialog.show());

    }
}