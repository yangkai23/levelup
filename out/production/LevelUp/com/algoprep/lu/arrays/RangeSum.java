package com.algoprep.lu.arrays;

import java.util.Scanner;

public class RangeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ar[][] = new int[scanner.nextInt()][scanner.nextInt()];
        int br[] = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < br.length; i++) {
            br[i] = scanner.nextInt();
        }
//        System.out.println(Arrays.toString(br));
        queries(ar, br);
        scanner.close();
    }

    private static void queries(int[][] ar, int[] br) {
        prefix(br);
        for (int i = 0; i < ar.length; i++) {
            int l = ar[i][0];
            int h = ar[i][1];
            System.out.println(l+" "+h);
            if (l > 0) System.out.println(br[h] - br[l - 1]);
            else {
                System.out.println(br[ar[i][1]]);
            }
        }
    }

    private static int[] prefix(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            ar[i] = ar[i] + ar[i - 1];
        }
        return ar;
    }
}
