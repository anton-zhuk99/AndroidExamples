package com.example.myfirstapp.module12.sqllite.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfirstapp.R;

public class UserActivity extends AppCompatActivity {

    private EditText nameBox;
    private EditText yearBox;
    private Button delButton;
    private Button saveButton;

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private Cursor userCursor;
    private long userId = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        nameBox = findViewById(R.id.name);
        yearBox = findViewById(R.id.year);
        delButton = findViewById(R.id.deleteButton);
        saveButton = findViewById(R.id.saveButton);

        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();

        userId = getIntent().getLongExtra("id", -1L);
        // if Добавить => userId = -1
        // if Элемент списка => userId = id

        if (userId > 0) {
            String sql = String.format(
                    "select * from %s where %s = ?",
                    DatabaseHelper.TABLE,
                    DatabaseHelper.COLUMN_ID);
            userCursor = db.rawQuery(
                    sql,
                    new String[] {String.valueOf(userId)}
                    );
            userCursor.moveToFirst();
            nameBox.setText(userCursor.getString(1));
            yearBox.setText(String.valueOf(userCursor.getInt(2)));
            userCursor.close();
        } else {
            delButton.setVisibility(View.GONE);
        }
    }

    public void save(View view){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, nameBox.getText().toString());
        cv.put(DatabaseHelper.COLUMN_YEAR, Integer.parseInt(yearBox.getText().toString()));

        // if Добавить => userId = -1
        // if Элемент списка => userId = id
        if (userId > 0) {
            db.update(
                    DatabaseHelper.TABLE,
                    cv,
                    DatabaseHelper.COLUMN_ID + " = ?",
                    new String[] {String.valueOf(userId)});
        } else {
            // insert into users(name, year) values(?, ?)
            db.insert(DatabaseHelper.TABLE, null, cv);
        }
        goHome();
    }

    public void delete(View view){
        db.delete(
                DatabaseHelper.TABLE,
                "_id = ?",
                new String[]{String.valueOf(userId)});
        goHome();
    }

    private void goHome(){
        db.close();
        Intent intent = new Intent(this, DatabaseWithHelperActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}