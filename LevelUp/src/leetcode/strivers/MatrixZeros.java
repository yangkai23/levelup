package leetcode.strivers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MatrixZeros {
    public void setZeroes(int[][] matrix) {
       /*

       My solution

       List<Pair> list = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }
        for (Pair pair : list) {

            Arrays.fill(matrix[pair.x], 0);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][pair.y] = 0;
            }
        }*/
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }

            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 1; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }
    }
}
