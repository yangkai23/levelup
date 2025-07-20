package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 20/07/25
 */
public class SubarraysWithKDifferentIntegersWithKMinus1 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public static int atMostK(int[] nums, int k) {
        if (k < 0) return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            right++;
            count += right - left + 1;
        }
        return count;
    }
}
