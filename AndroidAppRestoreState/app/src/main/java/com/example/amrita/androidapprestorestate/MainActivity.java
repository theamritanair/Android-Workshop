package com.example.amrita.androidapprestorestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState !=null){
            String input = savedInstanceState.getString("savedState");
        }
        setContentView(R.layout.activity_main);

        userInput =  findViewById(R.id.et_text);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String input = userInput.getText().toString();
        outState.putString("savedState", input);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String input = savedInstanceState.getString("savedState");
        userInput.setText(input);
    }
}
