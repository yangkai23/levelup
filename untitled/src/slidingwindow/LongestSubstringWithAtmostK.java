package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 13/07/25
 */
public class LongestSubstringWithAtmostK {
    public static void main(String[] args) {
        System.out.println(kDistinctChar("abcddefg", 3));
    }

    public static int kDistinctChar(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            if (map.size() <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }

        return maxLength;

    }
}
