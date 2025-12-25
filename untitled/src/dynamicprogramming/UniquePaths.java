package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 24/12/25
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 1));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findPathsUsingTabulation(m, n);
    }

    private static int findPathsUsingMemoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        int up = findPathsUsingMemoization(m - 1, n, dp);
        int left = findPathsUsingMemoization(m, n - 1, dp);

        dp[m][n] = up + left;
        return up + left;
    }

    private static int findPathsUsingTabulation(int m, int n) {

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int sum = 0;
                if (i - 1 >= 0)
                    sum += dp[i - 1][j];
                if (j - 1 >= 0)
                    sum += dp[i][j - 1];

                dp[i][j] = sum;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePathsUsingTabulationWithSpaceOptimization(int m, int n) {

        int[] currRow = new int[n];
        int[] prevRow = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    currRow[j] = 1;
                    continue;
                }
                currRow[j] = prevRow[j];
                if (j - 1 >= 0)
                    currRow[j] += currRow[j - 1];
            }

            System.arraycopy(currRow, 0, prevRow, 0, n);

        }
        return prevRow[n - 1];
    }

}
