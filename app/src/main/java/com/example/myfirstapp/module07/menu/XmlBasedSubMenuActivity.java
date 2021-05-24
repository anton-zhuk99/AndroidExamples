package com.example.myfirstapp.module07.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class XmlBasedSubMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_based_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_sub_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        TextView menuTextView = findViewById(R.id.menu_textview);
        switch(id) {
            case R.id.menu_item_1:
                menuTextView.setText(item.getTitle().toString());
                return true;
            case R.id.menu_item_2:
                menuTextView.setText(item.getTitle().toString());
                return false;
            case R.id.submenu_item_1:
                menuTextView.setText(item.getTitle().toString());
                return true;
            case R.id.submenu_item_2:
                menuTextView.setText(item.getTitle().toString());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}