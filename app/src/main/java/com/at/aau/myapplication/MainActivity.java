package com.at.aau.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button calculateButton;
    private Button sendButton;
    private TextView tv_answer;
    private EditText editInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendbutton);
        sendButton.setOnClickListener(this);

        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(this);

        tv_answer = findViewById(R.id.tv_answer);
        editInput = findViewById(R.id.editInput);

    }

    public void onClick(View view){
        if(view.getId() == R.id.sendbutton){
            TCPServerConnection();
        }
        if(view.getId() == R.id.calculateButton){
            CalculateBinary();
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
            this.tv_answer.setText("Fehler bei ServerVerbindung");
            e.printStackTrace();
        }
    }

    private void CalculateBinary(){
        BinaryTransformation bt = new BinaryTransformation(Integer.parseInt(getMatrikelnummerEingabe()));
        Thread t = new Thread(bt);
        t.start();
        try {
            t.join();
            this.tv_answer.setText(bt.getErgebnis());
        }catch (Exception e){
            this.tv_answer.setText("Fehler bei Berechnung");
            e.printStackTrace();
        }
    }

    public String getMatrikelnummerEingabe(){
        return editInput.getText().toString();
    }







}