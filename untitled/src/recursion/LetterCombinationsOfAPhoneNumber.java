package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 08/01/26
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] dialPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int n = digits.length();

        List<String> ans = new ArrayList<>();

        fn(0, digits, dialPad, ans, new StringBuilder(digits.length()));

        return ans;

    }

    static void fn(int digitIdx, String digits, String[] dialPad, List<String> ans, StringBuilder sb) {
        if (digitIdx == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = dialPad[digits.charAt(digitIdx) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            fn(digitIdx + 1, digits, dialPad, ans, sb);
            sb.deleteCharAt(sb.length() - 1);

        }

    }
}
