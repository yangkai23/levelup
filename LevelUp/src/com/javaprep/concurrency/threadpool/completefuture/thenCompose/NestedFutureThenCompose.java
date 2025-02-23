package com.javaprep.concurrency.threadpool.completefuture.thenCompose;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NestedFutureThenCompose {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("main :" + Thread.currentThread().getName());
                return "123";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        CompletableFuture<String> nestedFuture = future.thenComposeAsync(result -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("thenCompose :" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return result + " 321";
        }));
            nestedFuture.thenAccept(System.out::println).get();
    }
}
