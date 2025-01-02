package leetcode.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelStringInRange {
    public static void main(String[] args) {
        String[] words = {"a","e","i"};
        int[][] queries = {{0, 2}, {0,1}, {2, 2}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        prefix[0] = isVowelString(words[0], vowels) ? 1 : 0;
        for (int i = 1; i < words.length; i++) {
            String s = words[i];
            if (isVowelString(s, vowels)) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }
        int[] res=new int[queries.length];
        for(int i=0;i< queries.length;i++){
            if(queries[i][0]!=0)
            res[i]=prefix[queries[i][1]]-prefix[queries[i][0]-1];
            else
                res[i]=prefix[queries[i][1]];
        }
        return res;
    }

    public static boolean isVowelString(String s, Set<Character> vowels) {
        return vowels.contains(s.charAt(0)) && vowels.contains(s.charAt(s.length() - 1));
    }
}
