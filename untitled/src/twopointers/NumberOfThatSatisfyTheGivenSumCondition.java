package twopointers;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 17/12/25
 */
public class NumberOfThatSatisfyTheGivenSumCondition {
    public static int numSubSeq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int MOD = 1_000_000_007;
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        int left = 0;
        int right = n - 1;
        long count = 0;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                count = (count + pow2[right - left]) % MOD;
                left++;
            } else
                right--;
        }

        return (int) count;
    }
}
