package com.example.myfirstapp.module07.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myfirstapp.R;

public class DialogActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private Button showDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "White"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
//                .setMessage("Hello World")
                .setTitle("Simple dialog")
                .setPositiveButton("Hello!", (dialog, which) -> Toast.makeText(
                        DialogActivity.this,
                        "Hello!",
                        Toast.LENGTH_SHORT).show())
                .setNegativeButton("Cancel", (dialog, which) -> alertDialog.cancel())
                .setNeutralButton("Hi", (dialog, which) -> {
                    Toast.makeText(
                            DialogActivity.this,
                            "Okay..",
                            Toast.LENGTH_SHORT).show();
                    alertDialog.cancel();
                })
//                .setItems(colors, (dialog, which) -> {
//                    Toast.makeText(
//                            DialogActivity.this,
//                            colors[which],
//                            Toast.LENGTH_SHORT).show();
//                })
//                .setSingleChoiceItems(colors, -1, (dialog, which) -> {
//                    Toast.makeText(
//                            DialogActivity.this,
//                            colors[which],
//                            Toast.LENGTH_SHORT).show();
//                })
                .setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            Toast.makeText(
                                    DialogActivity.this,
                                    colors[which] + " checked",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(
                                    DialogActivity.this,
                                    colors[which] + " unchecked",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        alertDialog = builder.create();

        showDialogButton = findViewById(R.id.show_dialog_button);
        showDialogButton.setOnClickListener(v -> alertDialog.show());

    }
}