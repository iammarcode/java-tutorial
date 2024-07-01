package com.marco.unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        Unsafe unsafe = new Unsafe();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                unsafe.add();
                countDownLatch.countDown();
            });
        }

        System.out.println(Thread.currentThread().getName() + " is waiting");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " is done");
        executorService.shutdown();

        System.out.println(unsafe.get());
    }
}
