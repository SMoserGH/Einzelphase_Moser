package com.at.aau.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void ConnectionTest(){
        TCPServer server = new TCPServer("12034341");
        Thread t = new Thread(server);
        t.start();
        try {
            t.join();
            System.out.println(server.getOutput());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}