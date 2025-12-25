package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 25/12/25
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePathsUsingTabulationWithSpaceOptimization(obstacleGrid);
    }

    private static int uniquePaths(int[][] obstacleGrid, int m, int n) {

        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;
        if (obstacleGrid[m][n] == 1)
            return 0;

        int up = uniquePaths(obstacleGrid, m - 1, n);
        int left = uniquePaths(obstacleGrid, m, n - 1);

        return up + left;
    }

    private static int uniquePathsUsingMemoization(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        int up = uniquePathsUsingMemoization(obstacleGrid, m - 1, n, dp);
        int left = uniquePathsUsingMemoization(obstacleGrid, m, n - 1, dp);
        dp[m][n] = up + left;
        return up + left;
    }

    private static int uniquePathsUsingTabulation(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1)
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

    public static int uniquePathsUsingTabulationWithSpaceOptimization(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] currRow = new int[n];
        int[] prevRow = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    currRow[j] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    currRow[j] = 0;
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
