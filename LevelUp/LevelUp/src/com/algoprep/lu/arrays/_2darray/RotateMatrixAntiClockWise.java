package com.algoprep.lu.arrays._2darray;

import java.util.Scanner;

public class RotateMatrixAntiClockWise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ar = new int[scanner.nextInt()][scanner.nextInt()];
        int degreesToRotate = scanner.nextInt();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }
//        Transpose.printMatrix(ar);
        Transpose.printMatrix(rotate(ar, degreesToRotate));
        scanner.close();
    }

    static int[][] rotate(int[][] ar, int degreesToRotate) {
        int itr = degreesToRotate / 90;
        while (itr > 0) {
            Transpose.transpose(ar);
            System.out.println("printing");
            Transpose.printMatrix(ar);
            for (int i = 0; i < ar[0].length; i++) {
                reverse(ar, i);
            }
            itr--;
        }

        return ar;
    }

    static void reverse(int[][] ar, int col) {
        for (int i = 0; i < ar.length / 2; i++) {
            swap(ar, i, ar.length - 1 - i, col);
        }
    }

    static void swap(int[][] ar, int i, int j, int col) {
        int temp = ar[i][col];
        ar[i][col] = ar[j][col];
        ar[j][col] = temp;
    }
}
