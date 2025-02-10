package com.javaprep.concurrency.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    private final ReentrantLock lock;
    private final Condition condition;

    SharedResource(ReentrantLock lock) {
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public void consume() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " consumer thread acquired the lock");
            while (!isAvailable) {

                System.out.println(Thread.currentThread().getName() + " consumer thread is waiting");
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " consumer thread is unlocked");
            lock.unlock();
        }
    }

    public void produce() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " producer thread acquired the lock");
            while (isAvailable) {

                System.out.println(Thread.currentThread().getName() + " producer thread is waiting");
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " producer thread is unlocked");
            lock.unlock();
        }

    }
}