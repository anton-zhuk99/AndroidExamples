package com.example.myfirstapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myfirstapp.R;
import com.example.myfirstapp.module12.sqllite.helper.DatabaseWithHelperActivity;
import com.example.myfirstapp.module12.sqllite.simple.DatabaseActivity;
import com.example.myfirstapp.module14.multithreads.TwoThreadsActivity;
import com.example.myfirstapp.module14.simple.MultithreadActivity;

public class MainActivity extends AppCompatActivity
//        implements View.OnClickListener, View.OnTouchListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, TwoThreadsActivity.class);
        startActivity(intent);

//        EditText login = findViewById(R.id.editTextLogin);
//        login.setHint("Login");
//        login.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

//        Button button1 = findViewById(R.id.button1);
//        Button button2 = findViewById(R.id.button2);
//        Button button3 = findViewById(R.id.button3);
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
//        button1.setOnTouchListener(this);
//        button2.setOnTouchListener(this);
//        button3.setOnTouchListener(this);

//        RadioButton option1 = findViewById(R.id.option1);
//        RadioButton option2 = findViewById(R.id.option2);
//        RadioButton option3 = findViewById(R.id.option3);
//
//        option1.toggle();
//        boolean isRadioButtonChecked = option1.isChecked();
//        option1.setChecked(!isRadioButtonChecked);
//
//        option1.setOnCheckedChangeListener(new RadioButtonOnCheckedChangeListener());
//        option2.setOnCheckedChangeListener(new RadioButtonOnCheckedChangeListener());
//        option3.setOnCheckedChangeListener(new RadioButtonOnCheckedChangeListener());
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            Button b = (Button) v;
//            Toast toast = Toast.makeText(
//                    this,
//                    b.getId() + " pressed",
//                    Toast.LENGTH_LONG
//            );
//            toast.show();
//            return true;
//        }
//        return false;
//    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    @Override
//    public void onClick(View v) {
//        int buttonId = v.getId();
//        switch (buttonId) {
//            case R.id.button1: {
//                Button button = (Button) v;
//                Random rnd = new Random(System.currentTimeMillis());
//                float r = rnd.nextInt(100) / 100.0f;
//                float g = rnd.nextInt(100) / 100.0f;
//                float b = rnd.nextInt(100) / 100.0f;
//                button.setBackgroundColor(Color.argb(1.0f, r, g, b));
//                break;
//            }
////            case R.id.button2: {
////                Button button = (Button) v;
////                Random rnd = new Random(System.currentTimeMillis());
////                float r = rnd.nextInt(100) / 100.0f;
////                float g = rnd.nextInt(100) / 100.0f;
////                float b = rnd.nextInt(100) / 100.0f;
////                button.setBackgroundColor(Color.argb(0.5f, r, g, b));
////                break;
////            }
////            case R.id.button3: {
////                Button button = (Button) v;
////                Random rnd = new Random(System.currentTimeMillis());
////                float r = rnd.nextInt(100) / 100.0f;
////                float g = rnd.nextInt(100) / 100.0f;
////                float b = rnd.nextInt(100) / 100.0f;
////                button.setBackgroundColor(Color.argb(0.25f, r, g, b));
////                break;
////            }
//        }
//    }
//
//    public void onTextViewClick(View view) { // view - объект класса TextView
//        TextView textView = (TextView) view; // down-casting
//
//    }
//
//    public void onButtonClick(View view) {
//        String buttonText = ((Button) view).getText().toString();
//
//
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//
//        EditText editText = findViewById(R.id.editText);
//        String inputText = editText.getText().toString();
//
//        intent.putExtra("pi", 3.14);
//
//        intent.putExtra("inputText", inputText);
//        startActivity(intent); // смена активити
//    }

    // Intent - связывать два активити
    // activity
//    public void sendMessage(View view) {

//    }
}