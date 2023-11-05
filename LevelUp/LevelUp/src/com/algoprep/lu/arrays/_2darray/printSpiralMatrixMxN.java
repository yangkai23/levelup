package com.algoprep.lu.arrays._2darray;

import java.util.Scanner;

public class printSpiralMatrixMxN {
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
        int rsteps = ar[0].length - 1;
        int csteps = ar.length - 1;
        while (rsteps >= 1 && csteps >= 1) {
            for (int k = 0; k < csteps; k++) {
                System.out.print(ar[i][j] + " ");
                j++;
            }

            for (int k = 0; k < rsteps; k++) {
                System.out.print(ar[i][j] + " ");
                i++;
            }

            for (int k = 0; k < csteps; k++) {
                System.out.print(ar[i][j] + " ");
                j--;
            }

            for (int k = 0; k < rsteps; k++) {
                System.out.print(ar[i][j] + " ");
                i--;
            }
            rsteps -= 2;
            csteps -= 2;
            i++;
            j++;
        }

        if (rsteps == 0) {
            for (int k = 0; k < csteps; k++) {
                System.out.print(ar[i][j]);
                j++;
            }
        } else if (csteps == 0) {
            for (int k = 0; k < rsteps; k++) {
                System.out.print(ar[i][j]);
                i++;
            }
        }

        static void printMatrix ( int[][] ar){
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar[i].length; j++) {
                    System.out.print(ar[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
