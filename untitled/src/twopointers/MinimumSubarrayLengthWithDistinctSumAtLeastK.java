package twopointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Anirudh
 * @since 03/01/26
 */
public class MinimumSubarrayLengthWithDistinctSumAtLeastK {
    public static void main(String[] args) {
        int[] ar = {1, 12};
        System.out.println(minLength(ar, 7));
    }

    public static int minLength(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();

        int i = 0, j = 0;
        int distinctSum = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < n) {

            // add nums[j]
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            if (freq.get(nums[j]) == 1) {
                distinctSum += nums[j];
            }

            // try a shrinking window
            while (distinctSum >= k) {
                minLen = Math.min(minLen, j - i + 1);

                freq.put(nums[i], freq.get(nums[i]) - 1);
                if (freq.get(nums[i]) == 0) {
                    distinctSum -= nums[i];
                }
                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

}
