package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh
 * @since 11/01/26
 */
public class CountResiduePrefixes {
    public static void main(String[] args) {
        System.out.println(residuePrefixes("abc"));
    }

    public static int residuePrefixes(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            set.add(s.charAt(right));
            if ((right - left + 1) % 3 == set.size()) {
                count++;
            }
        }
        return count;
    }
}
