package com.algoprep.lu.arrays;

import java.util.Scanner;

public class MaxChunks1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(getNumOfChunks(ar));
        scanner.close();
    }

    private static int getNumOfChunks(int[] ar) {
        int ans = 0;
        int maxTillNow = ar[0];
        for (int i = 1; i < ar.length; i++) {
            maxTillNow = Math.max(maxTillNow, ar[i]);
            if (maxTillNow == i) ans++;
        }
        return ans;
    }
}
