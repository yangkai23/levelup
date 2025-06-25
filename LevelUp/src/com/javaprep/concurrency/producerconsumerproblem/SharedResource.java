package com.javaprep.concurrency.producerconsumerproblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private final Queue<Integer> bufferQueue;
    private final int bufferSize;

    public SharedResource(int bufferSize) {
        this.bufferQueue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void consume() {
        while (bufferQueue.isEmpty()) {
            try {
                System.out.println("shared buffer is empty");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Integer polled = bufferQueue.poll();
        notify();
    }

    public synchronized void produce(int item) {
        while (bufferQueue.size() == bufferSize) {
            try {
                System.out.println("shared buffer is full");
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        bufferQueue.offer(item);
        notify();
    }
}