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
        return getCost(n - 1, height, dp);

    }

    static int getCost(int n, int[] height, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) return dp[n];

        int left = getCost(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);

        int right = -1;
        if (n > 1) {
            right = getCost(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);
        }

        if (right != -1) dp[n] = Math.min(left, right);
        else dp[n] = left;
        return dp[n];
    }
}
