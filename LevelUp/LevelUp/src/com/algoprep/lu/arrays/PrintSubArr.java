package com.algoprep.lu.arrays;

import java.util.Scanner;

public class PrintSubArr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        print(ar);
        scanner.close();
    }

    private static void print(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(ar[k]+" ");
                }
                System.out.println();
            }
        }
    }
}
