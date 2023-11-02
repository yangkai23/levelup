package com.algoprep.lu.arrays._2darray;

import java.util.Scanner;

public class AllSubMatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ar = new int[scanner.nextInt()][scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }
//        Transpose.printMatrix(ar);
        int sum = getAllSubMatrixSum(ar);
        System.out.println("Sum : " + sum);
        scanner.close();
    }

    private static int getAllSubMatrixSum(int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                int frequency = 1;
                if (i > 0) frequency *= i + 1;
                if (j > 0) frequency *= j + 1;
                frequency *= ar.length - i;
                frequency *= ar[i].length - j;
                sum += frequency * ar[i][j];
            }
        }
        return sum;
    }
}
