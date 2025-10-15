package binarysearch;

/**
 * @author Anirudh
 * @since 15/10/25
 */
public class LongestBalancedSubstringI {
    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
    }
    public static int longestBalanced(String s) {
        int n = s.length();
        int[][] prefix = new int[n + 1][26];

        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                prefix[i + 1][c] = prefix[i][c];
            }
            prefix[i + 1][s.charAt(i) - 'a']++;
        }

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] freq = new int[26];
                for (int c = 0; c < 26; c++) {
                    freq[c] = prefix[j + 1][c] - prefix[i][c];
                }
                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private static boolean isBalanced(int[] freq) {
        int common = 0;
        for (int f : freq) {
            if (f > 0) {
                if (common == 0) common = f;
                else if (f != common) return false;
            }
        }
        return true;
    }
}
