package dynamicprogramming;

/**
 * @author Anirudh
 * @since 06/01/26
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++)
            dp[i][0] = matrix[i][0] - '0';
        for (int i = 0; i < m; i++)
            dp[0][i] = matrix[0][i] - '0';
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                max = Math.max(max, dp[i][j]);
            }

        }

        return max * max;
    }
}
