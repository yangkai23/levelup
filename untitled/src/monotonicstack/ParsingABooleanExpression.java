package monotonicstack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Anirudh
 * @since 06/01/26
 */
public class ParsingABooleanExpression {
    /**
     * Evaluates a boolean expression and returns its result.
     * <p>
     * The expression can contain:
     * - 't' for true
     * - 'f' for false
     * - '!' (NOT), '&' (AND), '|' (OR)
     * - Parentheses '(' and ')'
     * - Commas ',' as separators
     * <p>
     * Grammar (as per problem statement):
     * - !(expr)
     * - &(expr1, expr2, ...)
     * - |(expr1, expr2, ...)
     * <p>
     * Approach:
     * - Use a stack to process characters one by one.
     * - Push all characters except ')' and ',' onto the stack.
     * - When ')' is encountered:
     * - Pop elements until '(' is found and collect boolean values.
     * - Pop the operator just before '('.
     * - Apply the operator to the collected values.
     * - Push the result ('t' or 'f') back onto the stack.
     * <p>
     * The final result is the top of the stack.
     * <p>
     * Time Complexity: O(n)
     * - Each character is pushed and popped at most once
     * <p>
     * Space Complexity: O(n)
     * - Stack and temporary list for evaluation
     *
     * @param expression a valid boolean expression string
     * @return true if the expression evaluates to true, false otherwise
     */
    public boolean parseBoolExpr(String expression) {

        Stack<Character> stk = new Stack<>();

        for (char c : expression.toCharArray()) {

            // Ignore commas, push everything else except ')'
            if (c != ')' && c != ',') {
                stk.push(c);
            }
            // Evaluate expression inside parentheses
            else if (c == ')') {

                ArrayList<Boolean> exp = new ArrayList<>();

                // Collect boolean values until '('
                while (!stk.isEmpty() && stk.peek() != '(') {
                    char t = stk.pop();
                    exp.add(t == 't');
                }

                // Remove '('
                stk.pop();

                // Operator before '('
                char operator = stk.pop();
                boolean value = exp.getFirst();

                if (operator == '&') {
                    for (boolean b : exp) value &= b;
                } else if (operator == '|') {
                    for (boolean b : exp) value |= b;
                } else { // '!'
                    value = !value;
                }

                // Push a result back to stack
                stk.push(value ? 't' : 'f');
            }
        }

        // Final result
        return stk.peek() == 't';
    }

}
