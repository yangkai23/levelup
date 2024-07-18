package com.algoprep.lu.bits;

import java.util.Scanner;

public class MaxAndOfTwoNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int ar[] = new int[len];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        int result = getMax(ar);
        System.out.println("Result : " + result);
        scanner.close();
    }

    private static int getMax(int[] ar) {
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < ar.length; j++) {
                if (!CheckIthBitSet.isNthBitSet(ar[j], i)) count++;
            }
            if (count >= 2) {
                for (int j = 0; j < ar.length; j++) {
                    if (CheckIthBitSet.isNthBitSet(ar[j], i)) ar[j] = 0;
                }
            }
        }
        int idx1 = -1;
        int idx2 = -1;
        for (int j = 0; j < ar.length; j++) {
            if (ar[j] > 0 && idx1 == -1) {
                idx1 = ar[j];
            } else if (ar[j] > 0 && idx1 != -1) {
                idx2 = ar[j];
                break;
            }
        }
        return idx1 & idx2;

    }
}
