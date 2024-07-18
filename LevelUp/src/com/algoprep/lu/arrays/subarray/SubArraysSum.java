package com.algoprep.lu.arrays.subarray;

import java.util.Scanner;

public class SubArraysSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(getSum(ar));
        scanner.close();
    }

    private static int getSum(int[] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ((i + 1) * (ar.length - i)) * ar[i];
        }
        return sum;
    }
}
