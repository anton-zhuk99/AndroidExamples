package com.example.myfirstapp.module08.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myfirstapp.R;

public class TwoFragmentsActivity extends AppCompatActivity
        implements ListFragmentDataSender {

    // ListFragment => DetailsFragment
    @Override
    public void sendData(String contact, String phone) {
        DetailsFragment detailsFragment =
                (DetailsFragment)
                        getSupportFragmentManager()
                                .findFragmentById(R.id.textview_fragment_container);
        detailsFragment.setDetails(contact, phone);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_fragments);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.list_fragment_container, ListFragment.class, null)
                    .add(R.id.textview_fragment_container, DetailsFragment.class, null)
                    .commit();
        }
    }
}