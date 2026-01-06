package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 06/01/26
 */
public class BooleanParenthesization {
    static int countWays(String s) {


        int n = s.length();

        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }


        return fn(0, n - 1, 1, s, dp);

    }

    static int countWaysUsingTabulation(String s) {


        int n = s.length();

        int[][][] dp = new int[n + 2][n + 2][2];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'T') {
                dp[i][i][1] = 1;
                dp[i][i][0] = 0;
            } else if (s.charAt(i) == 'F') {
                dp[i][i][1] = 0;
                dp[i][i][0] = 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    int ways = 0;
                    for (int k = i + 1; k <= j - 1; k = k + 2) {
                        int lt = dp[i][k - 1][1];
                        int lf = dp[i][k - 1][0];
                        int rt = dp[k + 1][j][1];
                        int rf = dp[k + 1][j][0];


                        if (s.charAt(k) == '&') {
                            if (isTrue == 1) {
                                ways += lt * rt;
                            } else
                                ways += lf * rf + rt * lf + rf * lt;
                        } else if (s.charAt(k) == '|') {
                            if (isTrue == 1) {
                                ways += lt * rf + lt * rt + rt * lf;
                            } else
                                ways += lf * rf;
                        } else {
                            if (isTrue == 1) {
                                ways += lt * rf + rt * lf;
                            } else
                                ways += lf * rf + lt * rt;
                        }


                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }

        return dp[0][n - 1][1];

    }

    static int fn(int i, int j, int isTrue, String s, int[][][] dp) {
        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == 1) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];
        int ways = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lt = fn(i, k - 1, 1, s, dp);
            int lf = fn(i, k - 1, 0, s, dp);
            int rt = fn(k + 1, j, 1, s, dp);
            int rf = fn(k + 1, j, 0, s, dp);


            if (s.charAt(k) == '&') {
                if (isTrue == 1) {
                    ways += lt * rt;
                } else
                    ways += lf * rf + rt * lf + rf * lt;
            } else if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                    ways += lt * rf + lt * rt + rt * lf;
                } else
                    ways += lf * rf;
            } else {
                if (isTrue == 1) {
                    ways += lt * rf + rt * lf;
                } else
                    ways += lf * rf + lt * rt;
            }


        }

        dp[i][j][isTrue] = ways;

        return ways;
    }
}
