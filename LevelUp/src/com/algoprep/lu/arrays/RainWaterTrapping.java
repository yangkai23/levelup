package com.algoprep.lu.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RainWaterTrapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(getStorageUnits(ar));
        scanner.close();
    }

    private static int getStorageUnits(int[] ar) {
        int[] pmax = prefixMax(ar);
        int[] smax = suffixMax(ar);
        int storageUnits = 0;
        for (int i = 1; i < ar.length - 1; i++) {
            int left = pmax[i - 1];
            int right = smax[i + 1];
            int currentBlock = Math.min(left, right);
            int contrib = currentBlock - ar[i];
            if (contrib > 0) storageUnits += contrib;
        }
        return storageUnits;
    }

    private static int[] suffixMax(int[] ar) {
        int[] pmax = new int[ar.length];
        System.arraycopy(ar, 0, pmax, 0, ar.length);
        if (ar.length > 0) pmax[ar.length - 1] = ar[ar.length - 1];
        for (int i = ar.length - 2; i > 0; i--) {
//            System.out.println(ar[i]+" , "+pmax[i+1]);
            pmax[i] = Math.max(ar[i], pmax[i + 1]);
        }
        pmax[0] = Math.max(ar[0], pmax[1]);
        return pmax;
    }

    private static int[] prefixMax(int[] ar) {
        int[] smax = new int[ar.length];
        System.arraycopy(ar, 0, smax, 0, ar.length);
        if (ar.length > 0) smax[0] = ar[0];
        for (int i = 1; i < ar.length; i++) {
            smax[i] = Math.max(ar[i], smax[i - 1]);
        }
        return smax;
    }
}
