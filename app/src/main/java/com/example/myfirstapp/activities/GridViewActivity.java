package com.example.myfirstapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myfirstapp.R;
import com.example.myfirstapp.adapters.MyAdapter;
import com.example.myfirstapp.models.SignedImage;

import java.util.Arrays;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    private TextView mSelectText;
    private GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mSelectText = findViewById(R.id.info);
        gridView = findViewById(R.id.gridView1);

        List<SignedImage> data = Arrays.asList(
                new SignedImage(R.drawable.holy, "Holy"),
                new SignedImage(R.drawable.hot, "Hot"),
                new SignedImage(R.drawable.hugs, "Hugs"),
                new SignedImage(R.drawable.kiss, "Kiss"),
                new SignedImage(R.drawable.peace, "Peaceful"),
                new SignedImage(R.drawable.up, "Looking Up")
        );
        gridView.setAdapter(new MyAdapter(this, data));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // TODO Auto-generated method stub
                Log.d(
                        "MyLog",
                        "OnItemClickListener called, pos: " + position + ", id: " + id);
                String text = "Selected element: " + gridView.getAdapter().getItem(position);
                mSelectText.setText(text);
            }
        });
    }
}