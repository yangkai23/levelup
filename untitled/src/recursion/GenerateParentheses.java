package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 09/01/26
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        fn(n, ans, new StringBuilder("("), 1, 0);
        return ans;
    }

    static void fn(int n, List<String> ans, StringBuilder curr,
                   int openBracketCount, int closedBracketCount) {

        if (curr.length() == 2 * n) {
            ans.add(curr.toString());
            return;
        }

        if (openBracketCount < n) {
            curr.append('(');
            fn(n, ans, curr, openBracketCount + 1, closedBracketCount);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (closedBracketCount < openBracketCount) {
            curr.append(')');
            fn(n, ans, curr, openBracketCount, closedBracketCount + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

}
