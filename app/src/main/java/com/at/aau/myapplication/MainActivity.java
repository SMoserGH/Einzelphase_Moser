package com.at.aau.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mn_text;
    Button sendButton;
    TextView tv_answer;
    EditText editInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mn_text = findViewById(R.id.mn_text);
        sendButton = findViewById(R.id.sendbutton);
        tv_answer = findViewById(R.id.tv_answer);
        editInput = findViewById(R.id.editInput);

    }





}