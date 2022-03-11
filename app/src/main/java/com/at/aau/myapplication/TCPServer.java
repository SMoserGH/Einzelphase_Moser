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
    Socket clientSocket;
    DataOutputStream outToServer;
    BufferedReader inFromServer;

    public TCPServer(String matrikelnr){
        super();
        this.matrikelnr = matrikelnr;
    }

    @Override
    public void run() {
        try{
            clientSocket = new Socket("se2-isys.aau.at",53212);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

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

    public String getMatrikelnr(){
        return this.matrikelnr;
    }
}
