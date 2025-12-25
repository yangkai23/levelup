package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 25/12/25
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findMinSumUsingMemoization(grid, m - 1, n - 1, dp);
    }

    private static int findMinSum(int[][] grid, int m, int n) {
        if (m == 0 && n == 0)
            return grid[0][0];
        if (m < 0 || n < 0)
            return (int) 1e9;

        int up = grid[m][n] + findMinSum(grid, m - 1, n);
        int left = grid[m][n] + findMinSum(grid, m, n - 1);

        return Math.min(up, left);
    }

    private static int findMinSumUsingMemoization(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return grid[0][0];
        if (m < 0 || n < 0)
            return (int) 1e9;

        if (dp[m][n] != -1)
            return dp[m][n];

        int up = grid[m][n] + findMinSumUsingMemoization(grid, m - 1, n, dp);
        int left = grid[m][n] + findMinSumUsingMemoization(grid, m, n - 1, dp);

        dp[m][n] = Math.min(up, left);

        return dp[m][n];
    }

    private static int findMinSumUsingTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                int up = grid[i][j];
                int left = grid[i][j];

                if (i - 1 >= 0)
                    up += dp[i - 1][j];
                if (j - 1 >= 0)
                    left += dp[i][j - 1];

                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int findMinSumUsingTabulationWithSpaceOptimization(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] currRow = new int[n];
        int[] prevRow = new int[n];

        Arrays.fill(prevRow, (int) 1e9);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    currRow[j] = grid[0][0];
                    continue;
                }

                int left = (int) 1e9;

                int up = grid[i][j] + prevRow[j];
                if (j - 1 >= 0)
                    left = grid[i][j] + currRow[j-1];

                currRow[j] = Math.min(up, left);
            }
            System.arraycopy(currRow, 0, prevRow, 0, n);
        }
        return prevRow[n - 1];
    }
}
