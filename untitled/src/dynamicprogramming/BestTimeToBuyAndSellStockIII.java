package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 02/01/26
 */
public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return fn(n, 0, 1, prices, dp, 2);
    }

    static int fn(int n, int idx, boolean canBuy, int[] prices, int cap) {
        if (cap == 0)
            return 0;
        if (idx == n)
            return 0;

        if (canBuy) {
            return Math.max(-prices[idx] + fn(n, idx + 1, false, prices, cap), fn(n, idx + 1, true, prices, cap));
        } else {
            return Math.max(prices[idx] + fn(n, idx + 1, true, prices, cap - 1), fn(n, idx + 1, false, prices, cap));
        }
    }

    static int fn(int n, int idx, int canBuy, int[] prices, int[][][] dp, int cap) {
        if (cap == 0)
            return 0;
        if (idx == n)
            return 0;

        if (dp[idx][canBuy][cap] != -1)
            return dp[idx][canBuy][cap];
        if (canBuy == 1) {
            dp[idx][canBuy][cap] = Math.max(-prices[idx] + fn(n, idx + 1, 0, prices, dp, cap),
                    fn(n, idx + 1, 1, prices, dp, cap));
        } else {
            dp[idx][canBuy][cap] = Math.max(prices[idx] + fn(n, idx + 1, 1, prices, dp, cap - 1),
                    fn(n, idx + 1, 0, prices, dp, cap));
        }
        return dp[idx][canBuy][cap];
    }

    public static int maxProfitUsingTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        // not needed as default is zero.
        // base case
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j][0] = 0;
            }
        }.  same for idx==n */

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 1) {
                        dp[i][j][k] = Math.max(-prices[i] + dp[i + 1][0][k],
                                dp[i + 1][1][k]);
                    } else {
                        dp[i][j][k] = Math.max(prices[i] + dp[i + 1][1][k - 1],
                                dp[i + 1][0][k]);
                    }
                }
            }
        }

        return dp[0][1][2];

    }

    public static int maxProfitUsingTabulationWithSpaceOptimization(int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n + 1][2][3];

        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];

        // not needed as default is zero.
        // base case
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j][0] = 0;
            }
        }.  same for idx==n */

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 1) {
                        curr[j][k] = Math.max(-prices[i] + prev[0][k],
                                prev[1][k]);
                    } else {
                        curr[j][k] = Math.max(prices[i] + prev[1][k - 1],
                                prev[0][k]);
                    }
                }
            }

            System.arraycopy(curr[0], 0, prev[0], 0, 3);
            System.arraycopy(curr[1], 0, prev[1], 0, 3);
        }

        return prev[1][2];

    }
}
