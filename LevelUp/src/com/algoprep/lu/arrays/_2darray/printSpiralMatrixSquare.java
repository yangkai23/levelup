package com.algoprep.lu.arrays._2darray;

import java.util.Scanner;

public class printSpiralMatrixSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ar = new int[scanner.nextInt()][scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }
        printMatrix(ar);
        printBoundary(ar);
        scanner.close();
    }

    public static void printBoundary(int[][] ar) {
        int i = 0;
        int j = 0;
        int steps = ar.length - 1;
        while (steps >= 1) {
            for (int k = 0; k < steps; k++) {
                System.out.print(ar[i][j] + " ");
                j++;
            }

            for (int k = 0; k < steps; k++) {
                System.out.print(ar[i][j] + " ");
                i++;
            }

            for (int k = 0; k < steps; k++) {
                System.out.print(ar[i][j] + " ");
                j--;
            }

            for (int k = 0; k < steps; k++) {
                System.out.print(ar[i][j] + " ");
                i--;
            }
            steps -= 2;
            i++;
            j++;
        }

        if (steps == 0) System.out.println(ar[i][j]);
    }
    static void printMatrix(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }
}
