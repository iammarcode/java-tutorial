package com.marco.demo.threadSafe;

public class Demo {

    public static void main(String[] args) {
        // race condition
        NotThreadSafe sharedInstance = new NotThreadSafe();
        new Thread(() -> sharedInstance.add("thread-1")).start();
        new Thread(() -> sharedInstance.add("thread-2")).start();

        // not lead to race condition
        new Thread(() -> new NotThreadSafe().add("thread-1")).start();
        new Thread(() -> new NotThreadSafe().add("thread-2")).start();
    }
}
