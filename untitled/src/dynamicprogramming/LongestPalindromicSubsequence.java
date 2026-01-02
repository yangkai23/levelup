package dynamicprogramming;

/**
 * @author Anirudh
 * @since 01/01/26
 */
public class LongestPalindromicSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[] prev = new int[n2 + 1];
        int[] curr = new int[n2 + 1];

        for (int idx1 = 1; idx1 <= n1; idx1++) {
            for (int idx2 = 1; idx2 <= n2; idx2++) {

                if (text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)) {
                    curr[idx2] = 1 + prev[idx2 - 1];
                } else {
                    curr[idx2] = Math.max(prev[idx2], curr[idx2 - 1]);
                }
            }

            System.arraycopy(curr, 0, prev, 0, n2 + 1);
        }

        return prev[n2];

    }

    static String reverse(String s) {
        char[] ch = s.toCharArray();

        int i = 0;
        int j = ch.length - 1;

        while (i <= j) {
            char t = ch[i];
            ch[i] = ch[j];
            ch[j] = t;
            i++;
            j--;
        }
        return new String(ch);
    }
}
