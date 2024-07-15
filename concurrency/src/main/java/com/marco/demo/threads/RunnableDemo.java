package com.marco.demo.threads;

public class RunnableDemo {
    public static void main(String[] args) {
        // 1.implement Runnable
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();

        // 2.Anonymous
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Anonymous Runner is running");
            }
        };
        anonymousRunnable.run();

        // 3.Lambda
        Runnable lambdarunnable = () -> {
            System.out.println(Thread.currentThread().getName() + " Lambda Runner is running");
        };
        lambdarunnable.run();

        // 4.start a thread with a runnable, When the thread is started it will call the run() method of the MyRunnable instance instead of executing it's own run() method.
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Class Runner is running");
    }
}
