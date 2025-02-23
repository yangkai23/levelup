package com.javaprep.concurrency.threadpool.completefuture.thenCompose;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenComposeTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("main CompletableFuture :" + Thread.currentThread().getName());
                return "123";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },executorService);
        CompletableFuture<String> thenApply = future.thenCompose((string) -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thenApply :" + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(()->string+" 321");
        });
        thenApply.thenAccept(System.out::println).get();
    }

}
