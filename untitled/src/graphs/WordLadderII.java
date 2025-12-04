package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 03/12/25
 */
public class WordLadderII {
    public static void main(String[] args) {
        WordLadderII obj = new WordLadderII();
        System.out.println(obj.findLaddersOptimized("a", "c", List.of("a", "b", "c")));
    }

    String b;
    List<List<String>> ans;
    Map<String, Integer> map;

    public List<List<String>> findLaddersUsingNormalBFS(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        Set<String> set = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();
        Set<String> usedOnLevel = new HashSet<>();
        usedOnLevel.add(beginWord);
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<String> list = q.poll();
            String word = list.getLast();
            if (word.equals(endWord)) {
                if (ans.isEmpty()) {
                    ans.add(list);
                } else if (ans.getFirst().size() == list.size()) {
                    ans.add(list);
                }
            }
            if (list.size() > level) {
                level++;
                for (String val : usedOnLevel) {
                    set.remove(val);
                }
            }
            for (int i = 0; i < n; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = c;
                    String replacedStr = new String(wordArr);
                    if (set.contains(replacedStr)) {
                        list.add(replacedStr);
                        q.offer(list);
                        usedOnLevel.add(replacedStr);
                        list.removeLast();
                    }
                }
            }
        }
        return ans;
    }

    public List<List<String>> findLaddersOptimized(String beginWord, String endWord, List<String> wordList) {
        b = beginWord;
        map = ladderLength(beginWord, endWord, wordList);
        ans = new ArrayList<>();
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }

    private void dfs(String word, List<String> seq) {
        if (word.equals(b)) {
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        PriorityQueue<Pair> pairs=new PriorityQueue<>(Comparator.comparing((Pair p)->p.first));
        int steps = map.get(word);
        int sz = word.length();
        for (int i = 0; i < sz; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char[] wordArr = word.toCharArray();
                wordArr[i] = c;
                String replaced = new String(wordArr);
                if (map.containsKey(replaced) && map.get(replaced) == (steps - 1)) {
                    seq.add(replaced);
                    dfs(replaced, seq);
                    seq.removeLast();
                }
            }
        }

    }

    public Map<String, Integer> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        int n = beginWord.length();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return new HashMap<>();
        set.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord, 1);
        while (!q.isEmpty()) {
            String wrd = q.poll();
            int steps = map.get(wrd);
            if (wrd.equals(endWord))
                return map;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    char[] word = wrd.toCharArray();
                    word[i] = (char) (j + 'a');
                    String replaced = new String(word);
                    if (set.contains(replaced)) {
                        map.put(replaced, steps + 1);
                        q.offer(replaced);
                        set.remove(replaced);
                    }
                }
            }
        }
        return map;
    }
}
