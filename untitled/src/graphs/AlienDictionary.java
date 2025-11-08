package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh
 * @since 08/11/25
 */
public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"z", "x"};
        System.out.println(findOrder(words));
    }

    public static String findOrder(String[] words) {
        int n = words.length;
        List<List<Integer>> adJList = new ArrayList<>();
        boolean[] present = new boolean[26];
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                present[word.charAt(j) - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; i++) adJList.add(new ArrayList<>());


        for (int i = 1; i < n; i++) {
            String w1 = words[i - 1], w2 = words[i];
            int minLen = Math.min(w1.length(), w2.length());
            boolean foundEdge = false;

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adJList.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
                    foundEdge = true;
                    break;
                }
            }

            if (!foundEdge && w1.length() > w2.length()) return "";
        }

        StringBuilder topo = new StringBuilder();
        if (!getAlienDictOrder(topo, adJList, present)) return "";
        return topo.toString();


    }

    private static boolean getAlienDictOrder(StringBuilder topo, List<List<Integer>> adJList, boolean[] present) {
        int[] inDegree = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int adj : adJList.get(i)) {
                inDegree[adj]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] == 0) q.offer(i);
        }
        if (q.isEmpty()) return false;
        while (!q.isEmpty()) {
            int polled = q.poll();

            topo.append((char) ('a' + polled));
            for (int adj : adJList.get(polled)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0) q.offer(adj);
            }
        }
        int totalChars = 0;
        for (boolean b : present) if (b) totalChars++;
        return topo.length() == totalChars;
    }
}
