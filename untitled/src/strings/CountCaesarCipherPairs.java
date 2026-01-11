package strings;

import java.util.*;

/**
 * @author Anirudh
 * @since 11/01/26
 */
public class CountCaesarCipherPairs {
    public static void main(String[] args) {
        String[] words = {"a", "a", "a"};
        System.out.println(countPairs(words));
    }

    public static long countPairs(String[] words) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Set<String> visited = new HashSet<>();

        long ans = 0;
        for (String word : map.keySet()) {
            if (visited.contains(word))
                continue;
            visited.add(word);
            long groupCount = map.get(word);

            char[] base = word.toCharArray();
            for (int k = 1; k <= 25; k++) {
                char[] c = new char[base.length];
                for (int i = 0; i < word.length(); i++) {
                    c[i] = (char) ((base[i] - 'a' + k) % 26 + 'a');
                }
                String t = new String(c);
                if (map.containsKey(t) && !visited.contains(t)) {
                    groupCount += map.get(t);
                    visited.add(t);
                }
            }

            ans += groupCount * (groupCount - 1) / 2;

        }

        return ans;
    }

    public static long countPairsOptimized(String[] words) {

        Map<String, Integer> map = new HashMap<>();


        for (String word : words) {
            StringBuilder t = new StringBuilder(word.length());
            for (int i = 1; i < word.length(); i++) {
                int diff = (word.charAt(i) - word.charAt(i - 1) + 26) % 26;
                t.append(diff).append("#");
            }

            String pattern = t.toString();

            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
        }

        long ans = 0;

        for (long freq : map.values()) {
            ans += freq * (freq - 1) / 2;
        }
        return ans;
    }


}
