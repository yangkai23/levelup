package com.algoprep.lu.arrays;

import java.util.Scanner;

public class MissingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(getMissingElement(ar));
        scanner.close();
    }

    private static int getMissingElement(int[] ar) {
        int sp = 0;
        while (sp < ar.length) {
            if (ar[sp] < 0 || ar[sp] > ar.length || ar[sp] == (sp - 1)) {
                sp++;
            } else {
                swap(ar, ar[sp], sp);
            }
        }
        for (int i = 0; i < ar.length; i++) {
            if ((i + 1) != ar[i]) return i + 1;
        }
        return ar.length + 1;
    }

    private static void swap(int[] ar, int val, int sp) {
        int temp = ar[val - 1];
        ar[val - 1] = ar[sp];
        ar[sp] = temp;

    }
}
