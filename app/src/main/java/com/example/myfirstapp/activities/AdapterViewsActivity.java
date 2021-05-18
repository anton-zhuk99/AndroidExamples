package com.example.myfirstapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.myfirstapp.R;

import java.util.Arrays;
import java.util.List;

public class AdapterViewsActivity extends AppCompatActivity {

    // AdapterView - Spinner, ListView, GridView, Gallery

    // Adapters:
    // + BaseAdapter implements SpinnerAdapter, ListAdapter
    // | ArrayAdapter<T> extends BaseAdapter - ListView & Spinner
    // | SpinnerAdapter - Spinner
    // | SimpleAdapter
    // | SimpleCursorAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_views);

        List<String> data = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");

        Spinner spinner = findViewById(R.id.spinner);
        // Spinner spinnerInMain = findViewById(R.id.spinner_in_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // spinnerInMain.getContext()
                R.layout.spinner_textview, // R.layout.simple_spinner_item
                R.id.spinnerTextView2, // кастомный вид для выпадающего списка
                data
        );
        spinner.setAdapter(adapter);
    }
}