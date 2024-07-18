package com.algoprep.lu.arrays.subarray;

import java.util.Scanner;

public class KadanesAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(getMax(ar));
        scanner.close();
    }

    private static int getMax(int[] ar) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            if (sum < 0) sum = ar[i];
            else sum += ar[i];
            ans = Math.max(sum, ans);
        }
        return ans;
    }


}
