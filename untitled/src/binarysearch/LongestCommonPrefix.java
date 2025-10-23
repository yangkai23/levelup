package binarysearch;

/**
 * @author Anirudh
 * @since 22/10/25
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder(strs[0]);
        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < strs[i].length() && j < sb.length() && sb.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            sb.delete(j, sb.length());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String[] ar = {"uu", "hg", "ty"};
        System.out.println(longestCommonPrefix(ar));
    }
}
