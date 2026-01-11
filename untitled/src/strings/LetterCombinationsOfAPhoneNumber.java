package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 08/01/26
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        String[] dialPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int n = digits.length();
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            String t = dialPad[digits.charAt(0)-'0'];

            for (int i = 0; i < t.length(); i++) {
                ans.add(t.charAt(i) + "");
            }

            return ans;
        }

        String a = dialPad[digits.charAt(0)-'0'];
        String b = dialPad[digits.charAt(1)-'0'];

        for (int j = 0; j < a.length(); j++) {
            for (int k = 0; k < b.length(); k++) {
                ans.add(a.charAt(j) + "" + b.charAt(k));
            }
        }

        for (int i = 2; i < n; i++) {
            String c = dialPad[digits.charAt(i)-'0'];
            List<String> temp = new ArrayList<>();
            for (String val : ans) {
                for (int j = 0; j < c.length(); j++) {
                    temp.add(val + c.charAt(j));
                }
            }
            ans.clear();
            ans.addAll(temp);
        }

        return ans;

    }
}
