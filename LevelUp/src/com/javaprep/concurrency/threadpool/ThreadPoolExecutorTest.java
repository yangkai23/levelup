package com.javaprep.concurrency.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        try (ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(4), new MyThreadFactory(), new MyTaskRejectionHandler())) {
            for (int i = 1; i <= 10; i++) {


                executor.submit(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    System.out.println(Thread.currentThread().getName() + " is executing");
                });


            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}

class MyTaskRejectionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task has been rejected " + executor.getActiveCount());
    }
}
