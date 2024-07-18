package com.algoprep.lu.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxChunks2 {
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
        int[] pmax = prefixMax(ar);
        int[] smin = suffixMin(ar);
        System.out.println("pmax : "+ Arrays.toString(pmax));
        System.out.println("smin : "+ Arrays.toString(smin));
        for(int i=0;i<ar.length-1;i++){
            if(pmax[i]<smin[i+1])
                ans++;
        }
        return ++ans;
    }

    public static int[] prefixMax(int[] ar) {
        int psum[] = new int[ar.length];
        psum[0] = ar[0];
        for (int i = 1; i < ar.length; i++) {
            psum[i] = Math.max(ar[i], psum[i - 1]);
        }
        return psum;
    }

    public static int[] suffixMin(int[] ar) {
        int ssum[] = new int[ar.length];
        int len = ar.length;
        ssum[len - 1] = ar[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            ssum[i] = Math.min(ar[i], ssum[i + 1]);
        }
        return ssum;
    }
}
