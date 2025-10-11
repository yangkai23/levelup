package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 06/10/25
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int n = s.length();
        boolean[] alp = new boolean[128];
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (alp[c]) {
                alp[c] = false;
                ans += 2;
            } else {
                alp[c] = true;
            }
        }
        return ans == n ? ans : ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccccdd"));
    }
}
