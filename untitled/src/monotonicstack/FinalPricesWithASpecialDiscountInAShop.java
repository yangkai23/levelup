package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        System.out.println(Arrays.toString(finalPrices(prices)));
    }

    public static int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? prices[i] : prices[i] - prices[stack.peek()];
            stack.push(i);
        }
        return result;
    }
}
