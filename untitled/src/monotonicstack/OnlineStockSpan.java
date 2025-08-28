package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 26/08/25
 */
class StockSpanner {
    private final Deque<Pair> stack;
    int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        index = -1;
    }

    public int next(int price) {
        index++;
        while (!stack.isEmpty() && stack.peek().val <= price) {
            stack.pop();
        }
        int ans = index - (stack.isEmpty() ? -1 : stack.peek().index);
        stack.push(new Pair(price, index));
        return ans;
    }
}

class Pair {
    int val;
    int index;

    Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
