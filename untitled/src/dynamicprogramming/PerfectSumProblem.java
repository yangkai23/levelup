package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 28/12/25
 */
public class PerfectSumProblem {
    public static int perfectSum(int[] nums, int target) {

        int n = nums.length;

        int zeroes = 0;
        for (int val : nums) {
            if (val == 0) zeroes++;
        }

        int[] arr = new int[n - zeroes];

        int idx = 0;

        for (int val : nums) {
            if (val != 0) {
                arr[idx++] = val;
            }

        }
        int[][] dp = new int[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ways = fnUsingMemoization(arr, target, arr.length - 1, dp);

        return ways * (1 << zeroes);

    }

    static int fnUsingMemoization(int[] nums, int target, int n, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (n < 0) return 0;

        if (dp[n][target] != -1) return dp[n][target];

        int notTaken = fnUsingMemoization(nums, target, n - 1, dp);

        int taken = 0;
        if (target >= nums[n]) {
            taken = fnUsingMemoization(nums, target - nums[n], n - 1, dp);
        }

        dp[n][target] = taken + notTaken;
        return taken + notTaken;

    }

    static int fnUsingTabulation(int[] nums, int target) {
        int n = nums.length;

        int zeroes = 0;
        for (int val : nums) {
            if (val == 0) zeroes++;
        }

        if (zeroes == n) return (1 << zeroes);

        int[] arr = new int[n - zeroes];

        int idx = 0;

        for (int val : nums) {
            if (val != 0) {
                arr[idx++] = val;
            }

        }

        int[][] dp = new int[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= target) dp[0][arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int k = 1; k <= target; k++) {
                int notTaken = dp[i - 1][k];

                int taken = 0;
                if (k >= arr[i]) {
                    taken = dp[i - 1][k - arr[i]];
                }

                dp[i][k] = taken + notTaken;
            }
        }
        int ways = dp[arr.length - 1][target];


        return ways * (1 << zeroes);

    }

    static int fnUsingTabulationWithSpaceOptimization(int[] nums, int target) {
        int n = nums.length;

        int zeroes = 0;
        for (int val : nums) {
            if (val == 0) zeroes++;
        }

        if (zeroes == n)
            return (1 << zeroes);

        int[] arr = new int[n - zeroes];

        int idx = 0;

        for (int val : nums) {
            if (val != 0) {
                arr[idx++] = val;
            }

        }

        int[] curr = new int[target + 1];
        int[] prev = new int[target + 1];

        prev[0] = 1;
        curr[0] = 1;


        if (arr[0] <= target)
            prev[arr[0]] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int k = 1; k <= target; k++) {
                int notTaken = prev[k];

                int taken = 0;
                if (k >= arr[i]) {
                    taken = prev[k - arr[i]];
                }

                curr[k] = taken + notTaken;
            }
            System.arraycopy(curr, 0, prev, 0, target + 1);
        }
        int ways = prev[target];


        return ways * (1 << zeroes);

    }


}
