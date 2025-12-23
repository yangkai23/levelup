package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 23/12/25
 */
public class MaximumSumOfNonAdjacentElements {

    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findSumUsingTabulationSpaceOptimization(n, nums);
    }

    private int findSum(int n, int[] nums) {
        // if n is 0, then either index 2 was picked or index 1 was not picked
        if (n == 0) return nums[0];
        if (n < 0) return 0;

        // to not include adjacent, we are going for n-2
        int pick = nums[n] + findSum(n - 2, nums);

        // when not picking the curr val, we can pick n-1
        int notPick = findSum(n, nums);

        return Math.max(pick, notPick);
    }

    private int findSumUsingMemoization(int n, int[] nums, int[] dp) {
        // if n is 0, then either index 2 was picked or index 1 was not picked
        if (n == 0) return nums[0];
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];

        // to not include adjacent, we are going for n-2
        int pick = nums[n] + findSumUsingMemoization(n - 2, nums, dp);

        // when not picking the curr val, we can pick n-1
        int notPick = findSumUsingMemoization(n - 1, nums, dp);
        dp[n] = Math.max(pick, notPick);

        return dp[n];
    }

    private int findSumUsingTabulation(int n, int[] nums) {

        int[] dp = new int[n + 1];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1) take += dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n - 1];

    }

    private int findSumUsingTabulationSpaceOptimization(int n, int[] nums) {

        int prev = nums[0];
        int prev2 = 0;


        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1) take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }
        return prev;

    }
}
