package bits;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 03/02/26
 */
public class CountSubarraysWithGivenXorK {
    public int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int xor = 0;
        int count = 0;

        for (int val : nums) {
            xor ^= val;

            int target = xor ^ k;

            count += map.getOrDefault(target, 0);

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
