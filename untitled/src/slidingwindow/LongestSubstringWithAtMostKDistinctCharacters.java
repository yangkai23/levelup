package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 05/04/26
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(kDistinctChar("abcddefg", 3));
    }

    public static int kDistinctChar(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
