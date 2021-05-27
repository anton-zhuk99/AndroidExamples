package com.example.myfirstapp.module12.sqllite.simple;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_simple);
    }

    public void onClick(View view){
        SQLiteDatabase db = getBaseContext()
                .openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER)");
        db.execSQL("INSERT INTO users VALUES ('Tom Smith', 23)");
        db.execSQL("INSERT INTO users VALUES ('John Dow', 31)");

        Cursor query = db.rawQuery(
                "SELECT rowid, name, age FROM users",
                null);
        TextView textView = findViewById(R.id.textView);
        while (query.moveToNext()) {
            int id = query.getInt(0);
            String name = query.getString(1);
            int age = query.getInt(2);
            textView.append("Id: " + id + " Name: " + name + " Age: " + age + "\n");
        }
        query.close();
        db.close();
    }
}