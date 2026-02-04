package arrays;

/**
 * @author Anirudh
 * @since 27/01/26
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] ar) {
        int min = ar[0];
        int ans = 0;
        for (int val : ar) {
            ans = Math.max(ans, val - min);
            min = Math.min(min, val);
        }
        return ans;
    }
}
