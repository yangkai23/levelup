package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 14/07/25
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABCA", 1));
    }
    static{
        for(int i = 0; i < 500; i++){
            characterReplacement("", 1);
        }
    }

    public static int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxFrequency = 0;
        int[] hash = new int[26];
        while (right < s.length()) {
            hash[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency, hash[s.charAt(right) - 'A']);
            if ((right - left + 1) - maxFrequency > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            if ((right - left + 1) - maxFrequency <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}
