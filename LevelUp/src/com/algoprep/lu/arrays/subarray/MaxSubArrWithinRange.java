package com.algoprep.lu.arrays.subarray;

import java.util.Scanner;

public class MaxSubArrWithinRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        System.out.println(getMax(ar, left, right));
        scanner.close();
    }

    private static int getMax(int[] ar, int left, int right) {
        int prevCount = 0;
        int ans = 0;
        int lgei = 0;
        for (int ep = 0; ep < ar.length; ep++) {
            if (ar[ep] > right) {
                lgei = ep + 1;
                ans += 0;
                prevCount = 0;
            }
            if (ar[ep] <= left && ar[ep] > right) {
                ans += ep - lgei + 1;
                prevCount = ep - lgei + 1;

            }
            if (ar[ep] < left) {
                ans += prevCount;
            }
        }

        return ans;
    }
}
