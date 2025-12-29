package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 29/12/25
 */
public class ZeroOneKnapsackProblem {
    public static int knapsack(int W, int val[], int wt[]) {

        int n = wt.length;

        int[][] dp = new int[n][W + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fnUsingMemoization(n - 1, W, val, wt, dp);

    }

    static int fnUsingMemoization(int idx, int W, int[] val, int[] wt, int[][] dp) {

        if (idx == 0) {
            if (W >= wt[0]) {
                return val[0];
            } else {
                return 0;
            }
        }
        if (dp[idx][W] != -1)
            return dp[idx][W];

        int notTake = fnUsingMemoization(idx - 1, W, val, wt, dp);
        int take = Integer.MIN_VALUE;

        if (W >= wt[idx]) {
            take = val[idx] + fnUsingMemoization(idx - 1, W - wt[idx], val, wt, dp);
        }

        dp[idx][W] = Math.max(take, notTake);

        return Math.max(take, notTake);

    }

    public static int fnUsingTabulation(int W, int[] val, int[] wt) {
        int n = wt.length;

        int[][] dp = new int[n][W + 1];

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }


        for (int idx = 1; idx < n; idx++) {
            for (int weight = 0; weight <= W; weight++) {
                int notTake = dp[idx - 1][weight];
                int take = Integer.MIN_VALUE;

                if (weight >= wt[idx]) {
                    take = val[idx] + dp[idx - 1][weight - wt[idx]];
                }

                dp[idx][weight] = Math.max(take, notTake);

            }
        }

        return dp[n - 1][W];

    }

    public static int fnUsingTabulationWithSpaceOptimization(int W, int[] val, int[] wt) {

        int n = wt.length;
        int[] dp = new int[W + 1];
        for (int i = wt[0]; i <= W; i++) {
            dp[i] = val[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int weight = W; weight >= 0; weight--) {
                int notTake = dp[weight];
                int take = Integer.MIN_VALUE;

                if (weight >= wt[idx]) {
                    take = val[idx] + dp[weight - wt[idx]];
                }
                dp[weight] = Math.max(take, notTake);
            }
        }

        return dp[W];

    }
}
