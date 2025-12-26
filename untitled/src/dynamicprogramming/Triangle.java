package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh
 * @since 25/12/25
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(
                List.of(
                        List.of(2),
                        List.of(3, 4),
                        List.of(6, 5, 7),
                        List.of(4, 1, 8, 3)
                )
        );
        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findTotalUsingTabulationWithSpaceOptimization(triangle);
    }

    public static int findTotalUsingMemoization(int col, int row, List<List<Integer>> triangle, int[][] dp) {
        if (row == triangle.size() - 1)
            return triangle.get(row).get(col);

        if (dp[row][col] != -1)
            return dp[row][col];

        int curr = triangle.get(row).get(col);

        int down = curr + findTotalUsingMemoization(col, row + 1, triangle, dp);
        int diag = curr + findTotalUsingMemoization(col + 1, row + 1, triangle, dp);

        dp[row][col] = Math.min(down, diag);
        return dp[row][col];

    }

    public static int findTotalUsingTabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < triangle.getLast().size(); i++) {
            dp[n - 1][i] = triangle.getLast().get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int curr = triangle.get(i).get(j);
                int down = curr + dp[i + 1][j];
                int diag = curr + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diag);
            }
        }

        return dp[0][0];

    }

    public static int findTotalUsingTabulationWithSpaceOptimization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] currRow = new int[n];
        int[] prevRow = new int[n];

        for (int i = 0; i < triangle.getLast().size(); i++) {
            prevRow[i] = triangle.getLast().get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int curr = triangle.get(i).get(j);
                int down = curr + prevRow[j];
                int diag = curr + prevRow[j + 1];
                currRow[j] = Math.min(down, diag);
            }
            System.arraycopy(currRow, 0, prevRow, 0, n);
        }

        return prevRow[0];

    }
}
