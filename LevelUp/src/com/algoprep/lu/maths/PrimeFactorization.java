package com.algoprep.lu.maths;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] queries = new int[n];
        for (int i = 0; i < n; i++) {
            queries[i] = scanner.nextInt();
        }
        printPrimeFactors(queries);
        scanner.close();
    }

    private static void printPrimeFactors(int[] queries) {
        int max = Arrays.stream(queries).max().orElse(0);
        int[] spf = SmallestPrimeFactorSoEAlgo.getSmallestPrimeFactors(max);
        for (int j : queries) {
            int query = j;
            while (query > 1) {
                System.out.print(spf[query]);
                query /= spf[query];
                if (query > 1) System.out.print(" x ");
            }
            System.out.println();
        }

    }


}
