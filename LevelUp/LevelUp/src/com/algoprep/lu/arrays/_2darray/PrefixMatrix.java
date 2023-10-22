package com.algoprep.lu.arrays._2darray;

import java.util.Scanner;

public class PrefixMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ar = new int[scanner.nextInt()][scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Before :");
        Transpose.printMatrix(ar);
        System.out.println("After :");
        Transpose.printMatrix(getPrefix(ar));
        scanner.close();
    }

     static int[][] getPrefix(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1; j < ar[i].length; j++) {
                ar[i][j] = ar[i][j] + ar[i][j - 1];
            }
        }
        System.out.println("After row Summation :");
        Transpose.printMatrix(ar);
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1; j < ar[i].length; j++) {
                ar[j][i] = ar[j][i] + ar[j - 1][i];
            }
        }
        return ar;
    }
}
