package com.marco.demo.synchronization;

public class SynchronizedBlocks {
    private int count;
    public void performSynchronisedTask() {
        synchronized (this) {
            setCount(getCount()+1);
            //        System.out.println(Thread.currentThread().getName() + " is running: " + this.sum);
        }
    }

    public void setCount(int value) {
        this.count = value;
    }

    public int getCount() {
        return this.count;
    }
}
