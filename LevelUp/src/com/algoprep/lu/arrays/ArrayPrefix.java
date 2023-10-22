package com.algoprep.lu.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ar[] = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(prefix(ar)));
        scanner.close();
    }

    private static int[] prefix(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            ar[i] = ar[i] + ar[i - 1];
        }
        return ar;
    }
}
