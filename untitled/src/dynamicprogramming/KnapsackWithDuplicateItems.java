package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 30/12/25
 */
public class KnapsackWithDuplicateItems {

    // unbounded knapsack

    public static int knapSack(int val[], int wt[], int capacity) {

        int n = val.length;

        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findProfit(n - 1, val, wt, capacity, dp);

    }

    static int findProfit(int idx, int[] val, int[] wt, int capacity, int[][] dp) {
        if (idx == 0) {
            return ((capacity / wt[0])) * val[0];
        }
        if (dp[idx][capacity] != -1)
            return dp[idx][capacity];
        int notTake = findProfit(idx - 1, val, wt, capacity, dp);
        int take = 0;
        if (capacity >= wt[idx]) {
            take = val[idx] + findProfit(idx, val, wt, capacity - wt[idx], dp);
        }
        dp[idx][capacity] = Math.max(take, notTake);

        return Math.max(take, notTake);
    }

    static int findProfitUsingTabulation(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = wt[0]; i <= capacity; i++) {
            dp[0][i] = ((i / wt[0]) * val[0]);
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= capacity; w++) {
                int notTake = dp[i - 1][w];
                int take = 0;
                if (w >= wt[i]) {
                    take = val[i] + dp[i][w - wt[i]];
                }
                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][capacity];

    }

    static int findProfitUsingTabulationWithSpaceOptimization(int[] val, int[] wt, int capacity) {
        int n = val.length;


        int[] curr = new int[capacity + 1];
        int[] prev = new int[capacity + 1];

        for (int i = wt[0]; i <= capacity; i++) {
            prev[i] = ((i / wt[0]) * val[0]);
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= capacity; w++) {
                int notTake = prev[w];
                int take = 0;
                if (w >= wt[i]) {
                    take = val[i] + curr[w - wt[i]];
                }
                curr[w] = Math.max(take, notTake);
            }
            System.arraycopy(curr,0,prev,0,capacity+1);
        }

        return prev[capacity];

    }


}
