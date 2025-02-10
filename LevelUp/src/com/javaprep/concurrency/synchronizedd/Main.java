package com.javaprep.concurrency.synchronizedd;

public class Main {
    public static void main(String[] args) {
        SharedResource resource=new SharedResource();
        Thread t1=new Thread(resource::consume);
        Thread t2=new Thread(resource::consume);
        t1.start();
        t2.start();
    }
}
