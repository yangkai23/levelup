package binarysearch;

/**
 * @author Anirudh
 * @since 15/10/25
 */
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = Long.MIN_VALUE;
        for (int val : piles)
            high = Math.max(high, val);
        long ans = Long.MAX_VALUE;
        while (low <= high) {
            long mid = (low + high) / 2;
            long totalHours = getHoursSpent(mid, piles);

            if (totalHours <= h) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return (int)ans;
    }

    private static long getHoursSpent(long hour, int[] piles) {
        long sum = 0;
        for (int val : piles) {
            sum += (long) Math.ceil((double) val / hour);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        System.out.println(minEatingSpeed(piles,8));
    }
}
