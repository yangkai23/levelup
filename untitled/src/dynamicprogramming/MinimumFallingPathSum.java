package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 26/12/25
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(findMinSumUsingMemoization(matrix, n - 1, i, dp), min);
        }
        return min;
    }

    private int findMinSum(int[][] matrix, int row, int col) {

        if (col < 0 || col == matrix[0].length) {
            return (int) 1e9;
        }
        if (row == 0)
            return matrix[row][col];
        int curr = matrix[row][col];
        int up = curr + findMinSum(matrix, row - 1, col);
        int leftDiagonal = curr + findMinSum(matrix, row - 1, col - 1);
        int rightDiagonal = curr + findMinSum(matrix, row - 1, col + 1);

        return Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    private int findMinSumUsingMemoization(int[][] matrix, int row, int col, int[][] dp) {

        if (col < 0 || col == matrix[0].length) {
            return (int) 1e9;
        }
        if (row == 0)
            return matrix[row][col];
        if (dp[row][col] != -1)
            return dp[row][col];
        int curr = matrix[row][col];
        int up = curr + findMinSumUsingMemoization(matrix, row - 1, col, dp);
        int leftDiagonal = curr + findMinSumUsingMemoization(matrix, row - 1, col - 1, dp);
        int rightDiagonal = curr + findMinSumUsingMemoization(matrix, row - 1, col + 1, dp);

        dp[row][col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));

        return dp[row][col];
    }

    private int findMinSumUsingTabulation(int[][] matrix) {
        int n = matrix.length;
        // init first row of dp
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        //tabulate the rest of the cells
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int curr = matrix[row][col];
                int up = (int) 1e9;
                int leftDiagonal = (int) 1e9;
                int rightDiagonal = (int) 1e9;
                up = curr + dp[row - 1][col];
                if (col - 1 >= 0)
                    leftDiagonal = curr + dp[row - 1][col - 1];
                if (col + 1 < n)
                    rightDiagonal = curr + dp[row - 1][col + 1];

                dp[row][col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        int ans = Integer.MAX_VALUE;
        // find a min sum path to reach n-1 row
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    private int findMinSumUsingTabulationWithSpaceOptimization(int[][] matrix) {
        int n = matrix.length;
       // two arrays to hold a prev and curr array to eliminate 2d dp array
        int[] prevRow = new int[n];
        int[] currRow = new int[n];
        // init prevRow arr
        System.arraycopy(matrix[0], 0, prevRow, 0, n);

        //tabulate the rest of the cells using prevRow and add to currRow
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int curr = matrix[row][col];

                int leftDiagonal = (int) 1e9;
                int rightDiagonal = (int) 1e9;
                int up = curr + prevRow[col];
                if (col - 1 >= 0)
                    leftDiagonal = curr + prevRow[col - 1];
                if (col + 1 < n)
                    rightDiagonal = curr + prevRow[col + 1];

                currRow[col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }

            System.arraycopy(currRow, 0, prevRow, 0, n);
        }
        int ans = Integer.MAX_VALUE;
        // find a min sum path to reach n-1 row
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, prevRow[i]);
        }
        return ans;
    }
}
