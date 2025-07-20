package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 20/07/25
 */
public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            map.put(nums[right], right);
            while (map.size() > k) {
                if (map.get(nums[left]) <= left)
                    map.remove(nums[left]);
                left++;
            }

            if (map.size() == k) {
                int min = Integer.MAX_VALUE;
                for (int val : map.values()) {
                    min = Math.min(min, val);
                }
                count += 1 + min - left;
            }

            right++;
        }
        return count;
    }
}
