package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 28/10/25
 */
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
    }

    public static boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n != m)
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < n; i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < freq1.length; i++) {
            if ((freq1[i] != 0 && freq2[i] == 0) || (freq1[i] == 0 && freq2[i] != 0))
                return false;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : freq1) {
            if (j == 0)
                continue;
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (int j : freq2) {
            if (j == 0)
                continue;
            map.put(j, map.getOrDefault(j, 0) - 1);
        }
        for (int count : map.values()) {
            if (count != 0)
                return false;
        }
        return true;
    }
}
