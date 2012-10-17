package com.mycompany.app;


public class AppThread implements Runnable {
    @Override
    public void run() {
        System.out.println("App Thread running: " + Thread.currentThread().getName());
    }
}
