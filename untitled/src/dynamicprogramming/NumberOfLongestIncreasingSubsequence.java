package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 04/01/26
 */
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int max = 1;
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    // don't. need to add, just inherit
                    cnt[i] = cnt[prev];
                } else if (nums[prev] < nums[i] && 1 + dp[prev] == dp[i]) {
                    cnt[i] += cnt[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max)
                count += cnt[i];
        }

        return count;
    }
}
