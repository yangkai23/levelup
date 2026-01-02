package dynamicprogramming;

/**
 * @author Anirudh
 * @since 01/01/26
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        return subSeqCount(n, m, s, t);

    }

    static int subSeqCount(int n, int m, String s, String t) {
        if (m == 0)
            return 1;
        if (n == 0)
            return 0;

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            return subSeqCount(n - 1, m - 1, s, t) + subSeqCount(n - 1, m, s, t);
        } else {
            return subSeqCount(n - 1, m, s, t);
        }
    }


    static int subSeqCount(int n, int m, String s, String t, int[][] dp) {
        if (m == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            dp[n][m] = subSeqCount(n - 1, m - 1, s, t, dp) + subSeqCount(n - 1, m, s, t, dp);

        } else {
            dp[n][m] = subSeqCount(n - 1, m, s, t, dp);
        }
        return dp[n][m];
    }

    public static int numDistinctUsingTabulation(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];

    }

    public static int numDistinctUsingTabulationWithSpaceOptimization(String s, String t) {
        int n = s.length();
        int m = t.length();
        // int[] curr=new int[m+1];
        int[] prev = new int[m + 1];
        // int[][] dp = new int[n + 1][m + 1];


        prev[0] = 1;
        // curr[0] = 1;


        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    prev[j] = prev[j - 1] + prev[j];
                } else {
                    prev[j] = prev[j];
                }
            }

            // System.arraycopy(curr,0,prev,0,m+1);
        }

        return prev[m];

    }


}
