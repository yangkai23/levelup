package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 03/01/26
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fn(n, 0, 1, prices, dp, fee);
    }

    static int fn(int n, int idx, int canBuy, int[] prices, int[][] dp, int fee) {
        if (idx == n)
            return 0;

        if (dp[idx][canBuy] != -1)
            return dp[idx][canBuy];
        if (canBuy == 1) {
            dp[idx][canBuy] = Math.max(-prices[idx] + fn(n, idx + 1, 0, prices, dp, fee), fn(n, idx + 1, 1, prices, dp, fee));
        } else {
            dp[idx][canBuy] = Math.max(prices[idx] - fee + fn(n, idx + 1, 1, prices, dp, fee), fn(n, idx + 1, 0, prices, dp, fee));
        }
        return dp[idx][canBuy];
    }
    public int maxProfitUsingTabulation(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0],
                    dp[i + 1][1]);

            dp[i][0] = Math.max(prices[i]-fee + dp[i + 1][1],
                    dp[i + 1][0]);

        }

        return dp[0][1];
    }
    public int maxProfitUsingTabulationWithSpaceOptimization(int[] prices, int fee) {
        int n = prices.length;

        int curr1 = 0;
        int curr0 = 0;
        int prev1 = 0;
        int prev0 = 0;

        for (int i = n - 1; i >= 0; i--) {

            curr1 = Math.max(-prices[i] + prev0,
                    prev1);

            curr0 = Math.max(prices[i]-fee + prev1,
                    prev0);

            prev1 = curr1;
            prev0 = curr0;

        }

        return prev1;
    }
}
