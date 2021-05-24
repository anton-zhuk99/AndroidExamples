package com.example.myfirstapp.module07.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class XmlBasedMenuActivity extends AppCompatActivity {

    private boolean menuCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_based_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu myMenu) {
//        super.onCreateOptionsMenu(menu);
        // inflate - надувать (отрисовать)
        getMenuInflater().inflate(R.menu.simple_menu, myMenu);
//        if (menuCondition) {
//            return true;
//        }
//        return false;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView menuTextView = findViewById(R.id.menu_textview);
        switch(id) {
            case R.id.settings:
                menuTextView.setText("Настройки");
                return true;
            case R.id.open_settings:
                menuTextView.setText("Открыть");
                return true;
            case R.id.save_settings:
                menuTextView.setText("Сохранить");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}