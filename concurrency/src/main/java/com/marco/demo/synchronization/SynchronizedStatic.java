package com.marco.demo.synchronization;

public class SynchronizedStatic {
    private static int sum;

    public static synchronized void calculate() {
        setSum(getSum() + 1);
//        System.out.println(Thread.currentThread().getName() + " is running: " + sum);
    }

    public static int getSum() {
        return sum;
    }

    public static void setSum(int value) {
        sum = value;
    }
}
