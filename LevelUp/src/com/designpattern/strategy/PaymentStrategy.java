package com.designpattern.strategy;

public interface PaymentStrategy {
    /* Use Case 1: Sorting Algorithms

     In a software system, you may need to sort an array or a list of objects. There are several sorting algorithms available,
     such as QuickSort, MergeSort, BubbleSort, etc., each having its advantages and disadvantages, and their performance can vary depending upon the data.
     Here, the Strategy pattern can be utilized. We can create a SortStrategy interface with a sort() method and multiple sorting algorithms implementing this interface.
      The context class, which uses the sorting algorithm, would have a reference to the SortStrategy interface,
      allowing the client to change the sorting strategy at runtime.

     Use Case 2: Compression Algorithms

     Suppose you are building a file compression utility that can perform various types of compression like ZIP, RAR, or TAR.
     In this scenario, you can implement a CompressionStrategy interface that has a compress() method, and the different compression algorithms (ZIP, RAR, TAR)
     can be implemented as separate classes inheriting from the CompressionStrategy interface. The client can choose the required compression strategy without modifying
     the existing code, and you can also add new compression strategies in the future without affecting the client code.

     Use Case 3: Payment Strategies

     Let's consider an e-commerce application where multiple payment strategies such as credit card, PayPal,
     and digital wallets like Google Pay or Apple Pay are implemented. A PaymentStrategy interface can be created with a pay(amount) method.
     Different payment methods can be separate classes implementing this interface. In the checkout process,
      the client can choose the appropriate payment strategy without any change in the client code.
       This will also allow for easy addition of new payment strategies in the future.*/
    public void processPayment();
}
