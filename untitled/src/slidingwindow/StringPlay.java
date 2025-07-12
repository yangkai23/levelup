package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shanmukha Anirudh
 * @date 10/07/25
 */
public class StringPlay {
    public static int makeSteady(String input) {
        if (input == null || input.isEmpty()) return -1;

        int n = input.length();
        int target = n / 4;
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : input.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> excess = new HashMap<>();
        for (char ch : new char[]{'B', 'D', 'H', 'U'}) {
            int count = freq.getOrDefault(ch, 0);
            if (count > target) {
                excess.put(ch, count - target);
            }
        }

        if (excess.isEmpty()) return 0; // Already steady

        int left = 0, minLen = n;
        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char r = input.charAt(right);
            window.put(r, window.getOrDefault(r, 0) + 1);

            while (canReplace(window, excess)) {
                minLen = Math.min(minLen, right - left + 1);
                char l = input.charAt(left);
                window.put(l, window.get(l) - 1);
                left++;
            }
        }

        return minLen;
    }

    private static boolean canReplace(Map<Character, Integer> window, Map<Character, Integer> excess) {
        for (Map.Entry<Character, Integer> entry : excess.entrySet()) {
            char ch = entry.getKey();
            int required = entry.getValue();
            if (window.getOrDefault(ch, 0) < required) {
                return false;
            }
        }
        return true;
    } public static void main(String[] args) {
        System.out.println(makeSteady("HBBBUBBB")); // 0
        System.out.println(makeSteady("BBBBHHHH")); // 4
        System.out.println(makeSteady("BDBDBDHHHH")); // 2
    }

}
