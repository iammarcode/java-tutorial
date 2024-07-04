package com.marco.synchronization;

public class Unsafe {
    private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
        System.out.println(Thread.currentThread().getName() + " is running: " + this.sum);
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return this.sum;
    }
}
