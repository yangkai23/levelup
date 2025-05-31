package leetcode.strivers;

public class BuySellStock {
    public int maxProfit(int[] ar) {
        int min = ar[0];
        int profit = 0;
        for (int stock : ar) {
            if (stock > min) {
                int cost = stock - min;
                profit = Math.max(profit, cost);
            }

            min = Math.min(min, stock);
        }
        return profit;
    }
}
