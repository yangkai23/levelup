package com.javaprep.concurrency.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;


public class SharedResource {
    private boolean isAvailable = false;

    public void produce(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("acquired shared lock by " + Thread.currentThread().getName());
            //reads data
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("released shared lock by " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consume(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("acquired Exclusive lock by " + Thread.currentThread().getName());
            //reads data
            isAvailable = true;
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("released Exclusive lock by " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
