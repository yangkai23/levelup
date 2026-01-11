package dynamicprogramming;

/**
 * @author Anirudh
 * @since 08/01/26
 */
public class MaxDotProductOfTwoSubsequences {

    public static int maxDotProduct(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            dp[0][i] = -(int) 1e8;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -(int) 1e8;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int pick = a[i - 1] * b[j - 1] + Math.max(0, dp[i - 1][j - 1]);
                int skipA = dp[i - 1][j];
                int skipB = dp[i][j - 1];
                dp[i][j] = Math.max(pick, Math.max(skipA, skipB));
            }
        }

        return dp[n][m];
    }

    public static int maxDotProductWSO(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;
        int NEG = -(int) 1e8 / 2;
        int[] dp = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            dp[j] = NEG;
        }
        for (int i = 1; i <= n; i++) {

            int diag = dp[0];   // dp[i-1][0]
            dp[0] = NEG;        // dp[i][0]

            for (int j = 1; j <= m; j++) {

                int temp = dp[j];   // save dp[i-1][j]

                int pick = a[i - 1] * b[j - 1] + Math.max(0, diag);
                int skipA = dp[j];       // dp[i-1][j]
                int skipB = dp[j - 1];   // dp[i][j-1]

                dp[j] = Math.max(pick, Math.max(skipA, skipB));

                diag = temp; // move diagonal forward
            }
        }

        return dp[m];
    }

    static int fn(int i, int j, int[] a, int[] b, int[][] dp) {

        if (i < 0 || j < 0)
            return -(int) 1e8;
        if (dp[i][j] != -1)
            return dp[i][j];
        int pick = a[i] * b[j] + Math.max(0, fn(i - 1, j - 1, a, b, dp));
        int skipA = fn(i - 1, j, a, b, dp);
        int skipB = fn(i, j - 1, a, b, dp);
        dp[i][j] = Math.max(pick, Math.max(skipA, skipB));
        return dp[i][j];

    }
}
