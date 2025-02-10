package leetcode.daily;

public class CountWordsWithPrefix {
    public static int prefixCount(String[] words, String pref) {
        int len = pref.length();
        int result = 0;
        for (String word : words) {
            if (word.length() < len) continue;
           if(word.substring(0,len).equals(pref))
               result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        String prefix = "at";
        int result = prefixCount(words, prefix);
        System.out.println(result);
    }
}
