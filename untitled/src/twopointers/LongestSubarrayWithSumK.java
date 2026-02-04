package twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 03/02/26
 */
public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        System.out.println(longestSubarray(nums, 15));
    }

    public static int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }


            map.putIfAbsent(sum, i);
        }

        return maxLen;
    }


}
