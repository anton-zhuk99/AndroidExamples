package com.example.myfirstapp;

import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.option1:
                if (isChecked) {
                    Toast.makeText(
                            buttonView.getContext(),
                            "Правильно!",
                            Toast.LENGTH_LONG
                    ).show();
                }
                break;
            case R.id.option2:
                if (isChecked) {
                    Toast.makeText(
                            buttonView.getContext(),
                            "Не правильно!",
                            Toast.LENGTH_LONG
                    ).show();
                }
                break;
            case R.id.option3:
                if (isChecked) {
                    Toast.makeText(
                            buttonView.getContext(),
                            "Не правильно!",
                            Toast.LENGTH_LONG
                    ).show();
                }
                break;
        }
    }
}
