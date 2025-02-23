package com.javaprep.concurrency.threadpool.completefuture.thenApply;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NestedFuture {
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
        CompletableFuture<CompletableFuture<String>> nestedFuture = future.thenApply(result -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("thenApplyAsync :" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return result + " 321";
        }));
        nestedFuture.thenAccept(innerFuture -> {
            try {
                innerFuture.thenAccept(System.out::println).get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).get();
    }
}
