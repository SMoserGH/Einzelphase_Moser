package com.at.aau.myapplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable{
    String matrikelnr;
    String berechneteMatrikelnr;

    public TCPServer(String matrikelnr){
        this.matrikelnr = matrikelnr;
    }

    @Override
    public void run() {
        try{
            Socket clientSocket = new Socket("se2-isys.aau.at",53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(this.matrikelnr + '\n');
            this.berechneteMatrikelnr = inFromServer.readLine();
            clientSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getBerechneteMatrikelnr(){
        return this.berechneteMatrikelnr;
    }
}
