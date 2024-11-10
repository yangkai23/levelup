package leetcode.strivers;

import java.util.LinkedList;
import java.util.List;

public class MatrixZeros {
    public void setZeroes(int[][] matrix) {
        List<Pair> list = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }
        for (Pair pair : list) {

            for (int i = 0; i < matrix[pair.x].length; i++) {
                matrix[pair.x][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][pair.y] = 0;
            }
        }

    }

    class Pair {
        int x;
        int y;
        Pair(int i, int j) {
            x = i;
            y = j;
        }
    }
}
