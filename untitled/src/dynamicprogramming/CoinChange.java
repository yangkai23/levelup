package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 30/12/25
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = findCoinCount(n - 1, coins, amount, dp);
        return ans > 1e8 ? -1 : ans;
    }

    static int findCoinCount(int idx, int[] coins, int amount, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[idx] == 0)
                return amount / coins[idx];
            else
                return (int) 1e9;
        }
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int notTake = findCoinCount(idx - 1, coins, amount, dp);
        int take = (int) 1e9;
        if (amount >= coins[idx]) {
            take = 1 + findCoinCount(idx, coins, amount - coins[idx], dp);
        }
        dp[idx][amount] = Math.min(take, notTake);
        return Math.min(take, notTake);

    }

    static int findCoinCountTabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) 1e9;

        }

        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = dp[i - 1][tar];
                int take = (int) 1e9;
                if (tar >= coins[i]) {
                    take = 1 + dp[i][tar - coins[i]];
                }
                dp[i][tar] = Math.min(take, notTake);
            }
        }

        int ans = dp[n - 1][amount];
        return ans > 1e8 ? -1 : ans;

    }

    static int findCoinCountTabulationWithSpaceOptimization(int[] coins, int amount) {
        int n = coins.length;

        int[] curr = new int[amount + 1];
        int[] prev = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) 1e9;

        }
        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = prev[tar];
                int take = (int) 1e9;
                if (tar >= coins[i]) {
                    take = 1 + curr[tar - coins[i]];
                }
                curr[tar] = Math.min(take, notTake);
            }
            System.arraycopy(curr, 0, prev, 0, amount + 1);
        }

        int ans = prev[amount];
        return ans > 1e8 ? -1 : ans;

    }
}
