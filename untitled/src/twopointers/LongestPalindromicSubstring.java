package twopointers;

/**
 * @author Anirudh
 * @since 28/01/26
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abb"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();

        int max = 0;
        String res = "";

        for (int i = 0; i < n; i++) {

            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return res;
    }
}
