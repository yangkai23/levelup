package com.algoprep.lu.arrays._2darray;

import java.util.Scanner;

public class SubMatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ar = new int[scanner.nextInt()][scanner.nextInt()];
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }
        Transpose.printMatrix(ar);
        int sum = getSum(ar, x1, y1, x2, y2);
        System.out.println("Sum : " + sum);
        scanner.close();
    }

    private static int getSum(int[][] ar, int x1, int y1, int x2, int y2) {
        System.out.println("x1 :" + x1 + "  y1 :" + y1);
        System.out.println("x2 :" + x2 + "  y2 :" + y2);
        PrefixMatrix.getPrefix(ar);
        System.out.println("Prefix Matrix : ");
        Transpose.printMatrix(ar);
        System.out.println();
        int sum = ar[x2][y2];
        if (x1 > 0) {
            sum -= ar[x1 - 1][y2];
        }
        if (y1 > 0) {
            sum -= ar[x2][y1 - 1];
        }
        if (x1 > 0 && y1 > 0) {
            sum += ar[x1 - 1][y1 - 1];
        }
        return sum;
    }
}
