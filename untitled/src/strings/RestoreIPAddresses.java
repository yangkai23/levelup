package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 03/11/25
 */
public class RestoreIPAddresses {
    static List<String> result = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        result.clear();
        int n = s.length();
        if (n > 12) return List.of();

        solve(s, 0, 0, new StringBuilder(), n);
        return result;
    }

    private static void solve(String s, int idx, int parts, StringBuilder curr, int n) {
        if (idx == n && parts == 4) {
            result.add(curr.substring(0, curr.length() - 1));
            return;
        } else if (parts >= 4) {
            return;
        }

        for (int len = 1; len <= 3 && idx + len <= n; len++) {
            String sub = s.substring(idx, idx + len);
            if (isValid(sub)) {
                int prevLen = curr.length();
                curr.append(sub).append('.');
                solve(s, idx + len, parts + 1, curr, n);
                curr.setLength(prevLen);
            }
        }
    }

    public static boolean isValid(String str) {
        if (str.length() > 1 && str.charAt(0) == '0') return false;
        return Integer.parseInt(str) <= 255;
    }

}
