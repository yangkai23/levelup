package greedy;

/**
 * @author Anirudh
 * @since 03/10/25
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
