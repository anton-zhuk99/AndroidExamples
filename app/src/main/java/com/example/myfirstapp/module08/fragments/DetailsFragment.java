package com.example.myfirstapp.module08.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class DetailsFragment extends Fragment {

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    public void setDetails(String name, String phone) {
        TextView nameTextView = getView().findViewById(R.id.details_name_textview);
        TextView phoneTextView = getView().findViewById(R.id.details_phone_textview);
        nameTextView.setText(name + ":");
        phoneTextView.setText(phone);
    }
}