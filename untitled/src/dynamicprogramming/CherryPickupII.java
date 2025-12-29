package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 26/12/25
 */
public class CherryPickupII {
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return findMaxCherriesUsingMemoization(grid, 0, 0, m - 1, n, m, dp);
    }

    static int findMaxCherries(int[][] grid, int row, int col1, int col2, int n, int m) {
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return -(int) 1e9;
        }
        if (row == n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }
        int max = -(int) 1e9;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int val = 0;
                if (col1 == col2) {
                    val = grid[row][col1];
                } else
                    val = grid[row][col1] + grid[row][col2];

                val += findMaxCherries(grid, row + 1, col1 + i, col2 + j, n, m);
                max = Math.max(max, val);
            }
        }
        return max;
    }

    static int findMaxCherriesUsingMemoization(int[][] grid, int row, int col1, int col2, int n, int m, int[][][] dp) {
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return -(int) 1e9;
        }
        if (row == n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }

        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        int max = -(int) 1e9;
        int cherries = (col1 == col2)
                ? grid[row][col1]
                : grid[row][col1] + grid[row][col2];

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextCol1 = col1 + i;
                int nextCol2 = col2 + j;

                if (nextCol1 >= 0 && nextCol1 < m &&
                        nextCol2 >= 0 && nextCol2 < m) {

                    int val = cherries + findMaxCherriesUsingMemoization(grid, row + 1, col1 + i, col2 + j, n, m, dp);
                    max = Math.max(max, val);
                }
            }
        }
        dp[row][col1][col2] = max;
        return max;
    }

    static int findMaxCherriesUsingTabulation(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        //init last array for precomputed tabulation
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    dp[n - 1][i][j] = grid[n - 1][j];
                } else {
                    dp[n - 1][i][j] = grid[n - 1][i] + grid[n - 1][j];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < m; col1++) {
                for (int col2 = 0; col2 < m; col2++) {
                    int max = -(int) 1e9;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int val;
                            if (col1 == col2) {
                                val = grid[row][col1];
                            } else
                                val = grid[row][col1] + grid[row][col2];
                            if (col1 + i >= 0 && col2 + j >= 0 && col1 + i < m && col2 + j < m)
                                val += dp[row + 1][col1 + i][col2 + j];
                            else
                                val = -(int) 1e9;

                            max = Math.max(max, val);
                        }
                    }

                    dp[row][col1][col2] = max;
                }
            }
        }

        return dp[0][0][m - 1];

    }

    static int findMaxCherriesUsingTabulationWithSpaceOptimization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] prev = new int[m][m];
        int[][] curr = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(curr[i], -(int) 1e9);
        }

        //init last array for precomputed tabulation
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    prev[i][j] = grid[n - 1][j];
                } else {
                    prev[i][j] = grid[n - 1][i] + grid[n - 1][j];
                }
            }
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < m; col1++) {
                for (int col2 = 0; col2 < m; col2++) {
                    int max = -(int) 1e9;
                    int cherries = (col1 == col2)
                            ? grid[row][col1]
                            : grid[row][col1] + grid[row][col2];

                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int nextCol1 = col1 + i;
                            int nextCol2 = col2 + j;

                            if (nextCol1 >= 0 && nextCol1 < m &&
                                    nextCol2 >= 0 && nextCol2 < m) {

                                int val = cherries + prev[nextCol1][nextCol2];
                                max = Math.max(max, val);
                            }
                        }
                    }

                    curr[col1][col2] = max;
                }
            }

            for (int i = 0; i < m; i++) {
                System.arraycopy(curr[i], 0, prev[i], 0, m);
            }
        }

        return prev[0][m - 1];

    }
}
