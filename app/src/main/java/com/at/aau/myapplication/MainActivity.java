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

    public void TCPServerConnection(){
        TCPServer server = new TCPServer(getMatrikelnummerEingabe());
        Thread t = new Thread(server);
        t.start();

        try {
            t.join();
            this.tv_answer.setText(server.getBerechneteMatrikelnr());
        }catch (Exception e){
            this.tv_answer.setText("Fehler");
            e.printStackTrace();
        }
    }

    public String getMatrikelnummerEingabe(){
        return tv_answer.getText().toString();
    }







}