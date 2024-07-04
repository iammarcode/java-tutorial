package com.marco.demo.synchronization;

public class SynchronizedInstance {
    private int sum;

    public synchronized void calculate() {
        setSum(getSum() + 1);
//        System.out.println(Thread.currentThread().getName() + " is running: " + this.sum);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
