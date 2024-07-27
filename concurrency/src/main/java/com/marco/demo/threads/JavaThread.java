package com.marco.demo.threads;

public class JavaThread {
    public static void main(String[] args) throws InterruptedException {
        // 1.Implement Runnable (Custom Class)
        SampleRunnable sampleRunnable = new SampleRunnable();
        sampleRunnable.run();

        // 2.Anonymous (Custom Interface)
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

        // 4.Start a thread with a runnable, When the thread is started it will call the run() method
        // of the MyRunnable instance instead of executing it's own run() method.
        Thread thread = new Thread(sampleRunnable);
        thread.start();

        // 5.Custom thread name
        SampleRunnable customNameRunnable = new SampleRunnable();
        Thread customNameThread = new Thread(customNameRunnable, "Custom thread name");
        System.out.println("Thread name: " + customNameThread.getName());

        // 6.Get current thread
        String threadName = Thread.currentThread().getName();
        System.out.println("Current thread name: " + threadName);

        // 7.Executing order is in parallel and not sequentially.
        // The JVM and/or operating system determines the order in which the threads are executed.
        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    System.out.println("Thread: " + getName() + " is running");
                }
            }.start();
        }

        // 8.Pause a thread, not 100% precise
        Thread.sleep(3000);

        // 9.Stop from another thread
        TestStopRunnable testStopRunnable = new TestStopRunnable();
        Thread testStopThread = new Thread(testStopRunnable);
        testStopThread.start();

        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testStopRunnable.doStop();
    }


    static class SampleRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Class Runner is running");
        }
    }

    static class TestStopRunnable implements Runnable {

        private boolean doStop = false;

        public synchronized void doStop() {
            this.doStop = true;
        }

        private synchronized boolean keepRunning() {
            return this.doStop == false;
        }

        @Override
        public void run() {
            while(keepRunning()) {
                // keep doing what this thread should do.
                System.out.println("Running");

                try {
                    Thread.sleep(3L * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
