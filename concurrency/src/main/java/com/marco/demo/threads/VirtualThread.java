package com.marco.demo.threads;

public class VirtualThread {
    public static void main(String[] args) {


        Runnable runnable = () -> {
            for(int i=0; i<10; i++) {
                System.out.println("Index: " + i);
            }
        };

        Thread vThread = Thread.ofVirtual().start(runnable);
    }
}
