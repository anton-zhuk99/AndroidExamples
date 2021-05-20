package com.example.myfirstapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.myfirstapp.R;
import com.example.myfirstapp.adapters.CustomizedGalleryAdapter;

public class GalleryActivity extends AppCompatActivity {

    private Gallery simpleGallery;
    private CustomizedGalleryAdapter customGalleryAdapter;
    private ImageView selectedImageView;

    int[] images = {R.drawable.holy, R.drawable.hot, R.drawable.hugs,
                    R.drawable.kiss, R.drawable.peace, R.drawable.up};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        simpleGallery = findViewById(R.id.gallery);
        selectedImageView = findViewById(R.id.gallery_image);

        customGalleryAdapter = new CustomizedGalleryAdapter(this, images);

        simpleGallery.setAdapter(customGalleryAdapter);

        simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedImageView.setImageResource(images[position]);
            }
        });
    }
}