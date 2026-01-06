package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 04/01/26
 */
public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 2};
        System.out.println(longestBitonicSequence(5, nums));
    }

    /**
     * Computes the length of the Longest Bitonic Subsequence (LBS) in an array.
     * <p>
     * A Bitonic Subsequence is a sequence that:
     * - First strictly increases
     * - Then strictly decreases
     * - Both the increasing and decreasing parts must have length > 1
     * <p>
     * Approach:
     * - dp1[i]: length of the Longest Increasing Subsequence (LIS)
     * ending at index i (left to right).
     * - dp2[i]: length of the Longest Decreasing Subsequence (LDS)
     * starting at index i (right to left).
     * <p>
     * For each index i, treat nums[i] as the peak of the bitonic sequence:
     * bitonicLength = dp1[i] + dp2[i] - 1
     * <p>
     * The maximum such value across all valid peaks is the answer.
     * <p>
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param n    number of elements in the array
     * @param nums input array of integers
     * @return length of the longest bitonic subsequence;
     * returns 0 if no valid bitonic subsequence exists
     */
    public static int longestBitonicSequence(int n, int[] nums) {

        int[] dp1 = new int[n]; // LIS ending at i
        int[] dp2 = new int[n]; // LDS starting at i

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Compute LIS for each index (left to right)
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && dp1[prev] + 1 > dp1[i]) {
                    dp1[i] = dp1[prev] + 1;
                }
            }
        }

        // Compute LDS for each index (right to left)
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = n - 1; prev > i; prev--) {
                if (nums[prev] < nums[i] && dp2[prev] + 1 > dp2[i]) {
                    dp2[i] = dp2[prev] + 1;
                }
            }
        }

        int max = 0;

        // Combine LIS and LDS to find the maximum bitonic subsequence
        for (int i = 0; i < n; i++) {
            // Both sides must contribute (strictly increasing and decreasing)
            if (dp1[i] > 1 && dp2[i] > 1) {
                max = Math.max(max, dp1[i] + dp2[i] - 1);
            }
        }

        return max;
    }

}
