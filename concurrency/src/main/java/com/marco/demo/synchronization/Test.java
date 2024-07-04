package com.marco.demo.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class Test {
    @org.junit.Test
    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        int expected = 10000;
        int threadNum = 3;
        ExecutorService service = Executors.newFixedThreadPool(threadNum);
        NonSynchronized summation = new NonSynchronized();

        IntStream.range(0, expected).forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(expected, summation.getSum());
    }

    @org.junit.Test
    public void givenMultiThread_whenSyncMethod() throws InterruptedException {
        int expected = 10000;
        int threadNum = 3;
        ExecutorService service = Executors.newFixedThreadPool(threadNum);
        SynchronizedInstance summation = new SynchronizedInstance();

        IntStream.range(0, expected).forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(expected, summation.getSum());
    }

    @org.junit.Test
    public void givenMultiThread_whenStaticNonSyncMethod() throws InterruptedException {
        int expected = 10000;

        ExecutorService service = Executors.newCachedThreadPool();

        IntStream.range(0, expected).forEach(count -> service.submit(SynchronizedStatic::calculate));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(expected, SynchronizedStatic.getSum());
    }

    @org.junit.Test
    public void givenMultiThread_whenBlockSync() throws InterruptedException {
        int expected = 10000;

        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedBlocks synchronizedBlocks = new SynchronizedBlocks();

        IntStream.range(0, expected).forEach(count -> service.submit(synchronizedBlocks::performSynchronisedTask));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(expected, synchronizedBlocks.getCount());
    }

    @org.junit.Test
    public void givenMultiThread_whenStaticBlockSync() throws InterruptedException {
        int expected = 10000;

        ExecutorService service = Executors.newFixedThreadPool(3);

        IntStream.range(0, expected).forEach(count -> service.submit(SynchronizedStaticBlocks::performSynchronisedTask));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(expected, SynchronizedStaticBlocks.getCount());
    }
}
