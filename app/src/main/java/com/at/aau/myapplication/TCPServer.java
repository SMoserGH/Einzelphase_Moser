package com.at.aau.myapplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws Exception {
        long clientNumber = R.id.editNumber;
        long doubledNumber;

        ServerSocket welcomeSocket = new ServerSocket(53212);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            doubledNumber = clientNumber * 2 + '\n';
            outToClient.writeLong(doubledNumber);
        }
    }
}
