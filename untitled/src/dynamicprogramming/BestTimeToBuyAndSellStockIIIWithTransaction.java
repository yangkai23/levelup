package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 03/01/26
 */
public class BestTimeToBuyAndSellStockIIIWithTransaction {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int k=2;
        int[][] dp = new int[n][2*k];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fn(n, 0, prices, 0, k, dp);

    }

    static int fn(int n, int idx, int[] prices, int transaction, int k) {

        // we have 2 transactions at most so b s b s after num b-0,s-1,b-2,s-3. so even trans are buys and odd are sell
        if (transaction == 2 * k)
            return 0;
        if (idx == n)
            return 0;

        if (transaction % 2 == 0) {
            return Math.max(-prices[idx] + fn(n, idx + 1, prices, transaction + 1, k),
                    fn(n, idx + 1, prices, transaction, k));
        } else {
            return Math.max(prices[idx] + fn(n, idx + 1, prices, transaction + 1, k),
                    fn(n, idx + 1, prices, transaction, k));
        }
    }

    static int fn(int n, int idx, int[] prices, int transaction, int k, int[][] dp) {

        // we have 2 transactions at most so b s b s after num b-0,s-1,b-2,s-3. so even trans are buys and odd are sell
        if (transaction == 2 * k)
            return 0;
        if (idx == n)
            return 0;

        if (dp[idx][transaction] != -1)
            return dp[idx][transaction];
        if (transaction % 2 == 0) {
            dp[idx][transaction] = Math.max(-prices[idx] + fn(n, idx + 1, prices, transaction + 1, k, dp),
                    fn(n, idx + 1, prices, transaction, k, dp));

        } else {
            dp[idx][transaction] = Math.max(prices[idx] + fn(n, idx + 1, prices, transaction + 1, k, dp),
                    fn(n, idx + 1, prices, transaction, k, dp));
        }
        return dp[idx][transaction];
    }

    public static int maxProfitUsingTabulation(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][] dp = new int[n + 1][(2 * k) + 1];

        // no need to write base case because default is zero for int dp arrays

        for (int i = n - 1; i >= 0; i--) {
            for (int j = (2 * k) - 1; j >= 0; j--) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][j + 1], dp[i + 1][j]);


                } else {
                    dp[i][j] = Math.max(prices[i] + dp[i + 1][j + 1], dp[i + 1][j]);

                }
            }
        }

        return dp[0][0];

    }
    public static int maxProfitUsingTabulationWithSpaceOptimization(int[] prices) {
        int n = prices.length;
        int k = 2;

        int[] curr=new int[(2*k)+1];
        int[] after=new int[(2*k)+1];
        // int[][] dp = new int[n+1][(2 * k)+1];

        // no need to write base case because default is zero for int dp arrays

        for (int i = n-1; i >=0; i--) {
            for (int j = (2*k)-1; j >=0; j--) {
                if (j % 2 == 0) {
                    curr[j] = Math.max(-prices[i] + after[j+1],after[j]);


                } else {
                    curr[j] = Math.max(prices[i] + after[j+1],after[j]);

                }
            }
            System.arraycopy(curr,0,after,0,(2*k)+1);
        }

        return after[0];

    }
}
