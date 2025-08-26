package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 24/08/25
 */
public class RemoveKDigits {

    /**
     * Removes exactly k digits from the given numeric string `num` to produce
     * the smallest possible number. The result is represented as a string with
     * leading zeros removed. If the number becomes empty, "0" is returned.
     *
     * @param num The input string representing a non-negative numeric value.
     * @param k The number of digits to remove from the string `num`.
     * @return The smallest possible numeric string after removing k digits,
     *         with leading zeros removed. Returns "0" if the resulting number is empty.
     */
    public static String removeKDigits(String num, int k) {
        if (num == null || num.isEmpty()) return "0";

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        return idx == sb.length() ? "0" : sb.substring(idx);
    }


    public static void main(String[] args) {
        String num = "10001";
        int k = 1;
        System.out.println(removeKDigits(num, k));
    }
}
