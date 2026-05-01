package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shanmukhaanirudhtalluri
 * @date 26/06/25
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestNonRepeatingSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }


        return maxLength;
    }

    public static int longestNonRepeatingSubstring(String s) {

        int n = s.length();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            int idx = i;
            while (idx < n && !set.contains(s.charAt(idx))) {
                set.add(s.charAt(idx));
                idx++;
            }

           // brute force
                max = Math.max(max, idx - i);

        }

        return max;
    }
}
