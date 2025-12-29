package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 29/12/25
 */
public class PartitionsWithGivenDifference {
    public int countPartitions(int[] arr, int diff) {


        int totalSum = 0;
        for (int v : arr) totalSum += v;
        /*
         *  s1-s2=diff
         *  we know s1=total-s2
         *  so total-s2-s2=diff
         *  total-diff=2s2
         *  (total-diff)/2=s2
         *  edge cases are total-diff>0, and there should not be any fraction value for (total-diff)/2
         *
         *
         */

        if (totalSum - diff < 0 || (totalSum - diff) % 2 == 1) return 0;

        return perfectSum(arr, (totalSum - diff) / 2);

    }

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

    static int fnUsingMTabulation(int[] nums, int target) {

        int n = nums.length;
        // can be space optimized bt replacing 2d dp with prev and curr 1d array
        int[][] dp = new int[n][target + 1];

        if (nums[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if (nums[0] != 0 && nums[0] <= target) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= target; k++) {
                int notTaken = dp[i - 1][k];

                int taken = 0;
                if (k >= nums[i]) {
                    taken = dp[i - 1][k - nums[i]];
                }

                dp[i][k] = taken + notTaken;
            }
        }
        return dp[n - 1][target];

    }
}
