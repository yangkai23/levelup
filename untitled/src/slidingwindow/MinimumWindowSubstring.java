package slidingwindow;

/**
 * @author Anirudh
 * @since 10/11/25
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int[] hash = new int[256];
        int n = s.length();
        int m = t.length();
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
        while (right < n) {
            char c = s.charAt(right);
            if (hash[c] > 0) {
                count++;
            }
            hash[c]--;
            while (count == m) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0)
                    count--;
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex+minLen);
    }
}
