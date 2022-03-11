package com.at.aau.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mn_text;
    private Button sendButton;
    private TextView tv_answer;
    private EditText editInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mn_text = findViewById(R.id.mn_text);
        sendButton = findViewById(R.id.sendbutton);
        sendButton.setOnClickListener(this);
        tv_answer = findViewById(R.id.tv_answer);
        editInput = findViewById(R.id.editInput);

    }

    public void onClick(View view){
        if(view.getId() == R.id.sendbutton){
            TCPServerConnection();
        }
    }

    private void TCPServerConnection(){
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
        return editInput.getText().toString();
    }







}