package com.marco.demo.synchronization;

public class SynchronizedStaticBlocks {
    private static int count;
    public static void performSynchronisedTask() {
        synchronized (SynchronizedStaticBlocks.class) {
            setCount(getCount()+1);
            //        System.out.println(Thread.currentThread().getName() + " is running: " + this.sum);
        }
    }
    public static void setCount(int value) {
        count = value;
    }

    public static int getCount() {
        return count;
    }
}
