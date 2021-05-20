package com.example.myfirstapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class JavaBasedMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_based_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, R.string.menu_item_id_settings, 3, "Настройки"); // menu.add(R.string.menu_item);
        menu.add(Menu.NONE, R.string.menu_item_id_open, 2, "Открыть");
        menu.add(Menu.NONE, R.string.menu_item_id_save, 1, "Сохранить");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView tv = findViewById(R.id.menu_textview);
        String title = item.getTitle().toString();
        tv.setText(title);
        return true;
    }
}