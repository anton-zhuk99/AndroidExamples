package com.example.myfirstapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myfirstapp.R;

import java.util.Arrays;

public class GridViewActivity extends AppCompatActivity
//        implements AdapterView.OnItemSelectedListener
{

    private TextView mSelectText;
    private GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mSelectText = findViewById(R.id.info);
        gridView = findViewById(R.id.gridView1);

        gridView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")
        ));








//        gridView.setOnItemSelectedListener(this);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                // TODO Auto-generated method stub
//                String text = "Selected element: " + gridView.getAdapter().getItem(position);
//                mSelectText.setText(text);
//            }
//        });
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View v, int position,
//                               long id) {
//        mSelectText.setText("Selected element: " + gridView.getAdapter().getItem(position));
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        mSelectText.setText("Selected element: nothing");
//    }
}