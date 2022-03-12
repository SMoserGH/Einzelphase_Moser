package com.at.aau.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable {

    private String sentence;
    private String modifiedSentence;
    private Socket socket;

    public TCPServer(String sentence){
        this.sentence = sentence;
    }

    @Override
    public void run(){
        try {
            socket = new Socket("se2-isys.aau.at",53212);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeBytes(sentence + '\n');
            modifiedSentence = in.readLine();

            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public String getOutput(){
        return modifiedSentence;
    }
}
