package strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Anirudh
 * @since 28/10/25
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        System.out.println(makeGood("aBbAcC"));
    }

    public static String makeGood(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (top >= 0 && (stack[top] ^ c) == 32) {
                top--;
            } else {
                stack[++top] = c;
            }
        }

        return new String(stack, 0, top + 1);

    }
}
