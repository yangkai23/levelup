package twopointers;

import java.util.HashSet;
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

        Set<Integer> set = new HashSet<>();

        int i = 0, j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < n) {

            // shrink window if duplicate is coming
            while (i < j && set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            // add a new distinct element
            set.add(nums[j]);
            sum += nums[j];

            // try minimizing a window
            while (sum >= k) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
