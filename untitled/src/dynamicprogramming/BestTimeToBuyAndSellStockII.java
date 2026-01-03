package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 02/01/26
 */
public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fn(n, 0, 1, prices, dp);
    }

    static int fn(int n, int idx, boolean canBuy, int[] prices) {
        if (idx == n)
            return 0;

        if (canBuy) {
            return Math.max(-prices[idx] + fn(n, idx + 1, false, prices), fn(n, idx + 1, true, prices));
        } else {
            return Math.max(prices[idx] + fn(n, idx + 1, true, prices), fn(n, idx + 1, false, prices));
        }
    }

    static int fn(int n, int idx, int canBuy, int[] prices, int[][] dp) {
        if (idx == n)
            return 0;

        if (dp[idx][canBuy] != -1)
            return dp[idx][canBuy];
        if (canBuy == 1) {
            dp[idx][canBuy] = Math.max(-prices[idx] + fn(n, idx + 1, 0, prices, dp), fn(n, idx + 1, 1, prices, dp));
        } else {
            dp[idx][canBuy] = Math.max(prices[idx] + fn(n, idx + 1, 1, prices, dp), fn(n, idx + 1, 0, prices, dp));
        }
        return dp[idx][canBuy];
    }

    public static int maxProfitUsingTabulation(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0],
                    dp[i + 1][1]);

            dp[i][0] = Math.max(prices[i] + dp[i + 1][1],
                    dp[i + 1][0]);

        }

        return dp[0][1];

    }

    public static int maxProfitUsingTabulationWithSpaceOptimization(int[] prices) {
        int n = prices.length;

        // int[][] dp = new int[n + 1][2];

        int curr1 = 0;
        int curr0 = 0;
        int prev1 = 0;
        int prev0 = 0;

        for (int i = n - 1; i >= 0; i--) {

            curr1 = Math.max(-prices[i] + prev0,
                    prev1);

            curr0 = Math.max(prices[i] + prev1,
                    prev0);

            prev1 = curr1;
            prev0 = curr0;

        }

        return prev1;

    }
}
