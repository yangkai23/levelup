package prefixsuffix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 11/01/26
 */
public class NumberOfCenteredSubarrays {
    /**
     * Counts the number of "centered subarrays" in the given array.
     * <p>
     * A centered subarray is defined as a subarray that:
     * - Has a fixed center index `idx`
     * - Includes elements on both the left and right of the center
     * - The sum of elements on the left side equals the sum of elements
     * on the right side
     * <p>
     * Approach:
     * - Fix each index as the center.
     * - Compute all prefix sums on the right side and store their
     * frequencies in a hash map.
     * - Traverse leftwards from the center and maintain a running sum.
     * - For each left sum, check if the negated value exists in the map,
     * indicating a matching right-side sum.
     * <p>
     * Key Insight:
     * For a subarray centered at idx to be valid:
     * leftSum + rightSum = 0
     * ⇒ rightSum = -leftSum
     * <p>
     * Time Complexity: O(n^2)
     * - Each index is treated as a center
     * - Left and right scans are linear
     * <p>
     * Space Complexity: O(n)
     * - HashMap used to store right-side prefix sums
     *
     * @param nums input array of integers
     * @return total number of centered subarrays
     */
    public static int centeredSubarrays(int[] nums) {

        int n = nums.length;
        int ans = 0;

        // Fix each index as the center
        for (int idx = 0; idx < n; idx++) {

            // Map to store frequencies of right-side prefix sums
            Map<Integer, Integer> map = new HashMap<>();

            // Empty right side (sum = 0)
            map.put(0, 1);

            int rsum = 0;

            // Build prefix sums for the right side
            for (int i = idx + 1; i < n; i++) {
                rsum += nums[i];
                map.put(rsum, map.getOrDefault(rsum, 0) + 1);
            }

            int lsum = 0;

            // Case where the left side is empty
            ans += map.getOrDefault(0, 0);

            // Traverse left side and match sums
            for (int i = idx - 1; i >= 0; i--) {

                // Stop if the same value as a center is encountered
                if (nums[i] == nums[idx])
                    break;

                lsum += nums[i];

                // Count matching right sums
                ans += map.getOrDefault(-lsum, 0);
            }
        }
        return ans;
    }

}
