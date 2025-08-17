package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 13/08/25
 */

public class MinStack {
    private final Deque<Long> stack;
    private long minVal;

    public MinStack() {
        stack = new ArrayDeque<>();
        minVal = Long.MAX_VALUE;
    }

    public void push(long val) {
        if (stack.isEmpty()) {
            minVal = val;
            stack.push(val);
        } else if (val <= minVal) {
            stack.push(2L * val - minVal);
            minVal = val;
        } else {
            stack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            long x = stack.pop();
            if (x < minVal) {
                minVal = 2 * minVal - x;
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        long x = stack.peek();
        if (x >= minVal) return (int) x;
        else return (int) minVal;
    }

    public int getMin() {
        return (int) minVal;
    }
}

