package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 05/04/26
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long maxSum = 0;
        int left = 0;

        Map<Integer, Integer> lastSeen = new HashMap<>();

        long sum = 0;
        for (int right = 0; right < n; right++) {

            int currVal = nums[right];

            if (lastSeen.containsKey(currVal) && lastSeen.get(currVal) >= left) {

                int dupIndex = lastSeen.get(currVal);

                while (left <= dupIndex) {
                    sum -= nums[left];
                    left++;
                }
            }

            sum += currVal;
            lastSeen.put(currVal, right);

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                sum -= nums[left];
                left++;
            }

        }

        return maxSum;
    }
}
