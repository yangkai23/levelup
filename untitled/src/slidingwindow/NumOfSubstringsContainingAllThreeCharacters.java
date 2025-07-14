package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 13/07/25
 */
public class NumOfSubstringsContainingAllThreeCharacters {
    //https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public static int numberOfSubstrings(String s) {
        if (s == null || s.length() < 3) return 0;
        int len = s.length();
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        int count = 0;
        for (int i = 0; i < len; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]) + 1;
            }
        }

        return count;

    }
}
