package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 21/12/25
 */
public class FrogJump {
    static int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        return getCostUsingTabulation(n, height, dp);

    }

    static int getCostUsingMemoization(int n, int[] height, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) return dp[n];

        int left = getCostUsingMemoization(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);

        int right = -1;
        if (n > 1) {
            right = getCostUsingMemoization(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);
        }

        if (right != -1) dp[n] = Math.min(left, right);
        else dp[n] = left;
        return dp[n];
    }

    static int getCostUsingTabulation(int n, int[] height, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }

            dp[i] = Math.min(left, right);

        }
        return dp[n - 1];

    }

    static int getCostUsingNoAddSpace(int n, int[] height) {
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(height[i] - height[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(height[i] - height[i - 2]);
            }

            int curr = Math.min(left, right);

            prev2 = prev;
            prev = curr;

        }
        return prev;

    }
}
