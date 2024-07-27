package com.marco.demo.virtualThread;

public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        //1.run virtual thread
        runVirtualThread();

    }

    private static void runVirtualThread() throws InterruptedException {
        Runnable task = () -> {
            for(int i=0; i<10; i++) {
                System.out.println("Index: " + i);
            }
        };

        Thread.Builder builder = Thread.ofVirtual().name("My virtual thread");
        Thread vThread = builder.start(task);

        System.out.println("Thread t name: " + vThread.getName());

        vThread.join();
    }
}
