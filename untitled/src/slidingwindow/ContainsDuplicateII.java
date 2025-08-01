package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 01/08/25
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            if (map.containsKey(nums[right])) {
                if (right - map.get(nums[right]) <= k) {
                    return true;
                }
            }
            map.put(nums[right], right);
        }
        return false;
    }
}
