package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 03/01/26
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fn(n, 0, true, prices);
    }

    static int fn(int n, int idx, boolean canBuy, int[] prices) {
        if (idx >= n)
            return 0;

        if (canBuy) {
            return Math.max(-prices[idx] + fn(n, idx + 1, false, prices), fn(n, idx + 1, true, prices));
        } else {
            return Math.max(prices[idx] + fn(n, idx + 2, true, prices), fn(n, idx + 1, false, prices));
        }
    }

    static int fn(int n, int idx, int canBuy, int[] prices, int[][] dp) {
        if (idx >= n)
            return 0;

        if (dp[idx][canBuy] != -1)
            return dp[idx][canBuy];
        if (canBuy == 1) {
            dp[idx][canBuy] = Math.max(-prices[idx] + fn(n, idx + 1, 0, prices, dp), fn(n, idx + 1, 1, prices, dp));
        } else {
            dp[idx][canBuy] = Math.max(prices[idx] + fn(n, idx + 2, 1, prices, dp), fn(n, idx + 1, 0, prices, dp));
        }
        return dp[idx][canBuy];
    }

    public int maxProfitUsingTabulation(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0],
                    dp[i + 1][1]);

            dp[i][0] = Math.max(prices[i] + dp[i + 2][1],
                    dp[i + 1][0]);

        }

        return dp[0][1];
    }

    /**
     * Computes the maximum profit from stock trading with a cooldown period
     * using space-optimized dynamic programming.
     * <p>
     * Problem rules:
     * - You may complete as many transactions as you like.
     * - You must sell before you buy again.
     * - After selling a stock, you must wait one day (cooldown) before buying again.
     * <p>
     * DP State Definition:
     * - dp[i][1]: maximum profit on day i when you are allowed to buy
     * - dp[i][0]: maximum profit on day i when you are holding a stock (must sell next)
     * <p>
     * Transitions:
     * - Buy state:
     * dp[i][1] = max(-prices[i] + dp[i+1][0], dp[i+1][1])
     * <p>
     * - Sell state (cooldown applies):
     * dp[i][0] = max(prices[i] + dp[i+2][1], dp[i+1][0])
     * <p>
     * Space Optimization:
     * - prev1[] represents dp[i+1][*]
     * - prev2[] represents dp[i+2][*]
     * - curr[]  represents dp[i][*]
     * <p>
     * The algorithm iterates backwards from the last day to day 0.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param prices array where prices[i] is the stock price on day i
     * @return maximum achievable profit
     */
    public int maxProfitUsingTabulationWithSpaceOptimization(int[] prices) {
        int n = prices.length;

        // prev1 -> dp[i+1], prev2 -> dp[i+2], curr -> dp[i]
        int[] prev1 = new int[2];
        int[] prev2 = new int[2];
        int[] curr = new int[2];

        for (int i = n - 1; i >= 0; i--) {

            // Buy decision (allowed to buy)
            curr[1] = Math.max(
                    -prices[i] + prev1[0], // buy today
                    prev1[1]                // skip today
            );

            // Sell decision (holding a stock)
            curr[0] = Math.max(
                    prices[i] + prev2[1],  // sell today, cooldown applies
                    prev1[0]               // skip today
            );

            // Shift DP states forward
            System.arraycopy(prev1, 0, prev2, 0, 2);
            System.arraycopy(curr, 0, prev1, 0, 2);
        }

        // Starting on day 0 with the option to buy
        return prev1[1];
    }

}
