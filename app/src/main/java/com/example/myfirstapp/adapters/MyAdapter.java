package com.example.myfirstapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfirstapp.R;
import com.example.myfirstapp.models.SignedImage;

import java.util.List;

public class MyAdapter extends ArrayAdapter<SignedImage> { // extends BaseAdapter

    private List<SignedImage> objects;

    public MyAdapter(
            @NonNull Context context,
            List<SignedImage> objects) {
        super(context, R.layout.gridview_template, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        SignedImage si = getItem(position);
        SignedImage si = objects.get(position);

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.gridview_template, parent, false);
        }

        ImageView iv = convertView.findViewById(R.id.image);
        iv.setImageResource(si.getId());

        TextView tv = convertView.findViewById(R.id.image_text);
        tv.setText(si.getText());

        return convertView;
    }
}
