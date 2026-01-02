package dynamicprogramming;

/**
 * @author Anirudh
 * @since 31/12/25
 */
public class RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }

    public static int cutRod(int[] price) {
        int n = price.length;
        int[] prev = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = i * price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int wt = 0; wt <= n; wt++) {

                int notTaken = prev[wt];
                int taken = -(int) 1e9;

                if (wt >= (i + 1)) {
                    taken = price[i] + prev[wt - (i + 1)];
                }

                prev[wt] = Math.max(taken, notTaken);
            }
        }

        return prev[n];
    }
}
