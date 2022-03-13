package com.at.aau.myapplication;

public class BinaryTransformation implements Runnable{

    private int matrikelnr;
    private String result;

    public BinaryTransformation(int mnr){
        this.matrikelnr = mnr;
    }

    public String getErgebnis(){
        return this.result;
    }

    @Override
    public void run() {
        this.result = getBinaryNumberAsString(getQuersumme(matrikelnr));
    }

    private int getQuersumme(int nummer){
        int summe = 0;

        while(nummer > 0){
            summe += nummer%10;
            nummer = nummer/10;
        }

        return summe;
    }

    private String getBinaryNumberAsString(int nummer){
        StringBuilder binary = new StringBuilder();
        while(nummer > 0){
            binary.append(nummer%2);
            nummer = nummer/2;
        }
        return binary.reverse().toString();
    }
}
