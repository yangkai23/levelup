package com.algoprep.lu.arrays.subarray;

import java.util.Scanner;

public class SubArrSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        getSum(ar);
        scanner.close();
    }

    private static void getSum(int[] ar) {
        prefix(ar);
        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                if (i == 0) {
                    System.out.println(ar[j]);
                    continue;
                }
                System.out.println(ar[j] - ar[i - 1]);
            }
        }

    }

    private static int[] prefix(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            ar[i] = ar[i] + ar[i - 1];
        }
        return ar;
    }
}
