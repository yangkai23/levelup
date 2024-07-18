package com.algoprep.lu.maths;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestPrimeFactorSoEAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums  = getSmallestPrimeFactors(n);
        System.out.println(Arrays.toString(nums));
        scanner.close();
    }

    public static int[] getSmallestPrimeFactors(int n) {
        int ar[] = new int[n + 1];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (ar[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    ar[j] = Math.min(ar[j],i);
                }
            }
        }
        return ar;
    }
}
