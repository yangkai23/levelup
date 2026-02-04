package arrays;

import java.util.HashSet;

/**
 * @author Anirudh
 * @since 03/02/26
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Long> set = new HashSet<>();
        for (int val : nums) {
            set.add((long) val);
        }

        int count = 0;
        for (long num : nums) {
            boolean countOnce = false;
            if (set.contains(num - 1)) {
                count += 2;
                countOnce = true;
                set.remove(num - 1);
            }
            if (set.contains(num + 1)) {
                if (countOnce) count++;
                else
                    count += 2;
                set.remove(num + 1);
            }
            set.remove(num);

        }
        return count;
    }
}
