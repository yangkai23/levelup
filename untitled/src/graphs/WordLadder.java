package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 02/12/25
 */
public class WordLadder {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = beginWord.length();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Queue<WordPair> q = new LinkedList<>();
        q.offer(new WordPair(beginWord, 1));
        while (!q.isEmpty()) {
            WordPair pair = q.poll();
            if (pair.first.equals(endWord))
                return pair.second;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    char[] word = pair.first.toCharArray();
                    word[i] = (char) (j + 'a');
                    String replaced=new String(word);
                    if (set.contains(replaced)) {
                        q.offer(new WordPair(replaced, pair.second + 1));
                        set.remove(replaced);
                    }
                }
            }
        }
        return 0;
    }
}

class WordPair {
    String first;
    int second;

    WordPair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
