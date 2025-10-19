package binarysearch;

/**
 * @author Anirudh
 * @since 16/10/25
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        long low = Integer.MAX_VALUE;
        long high = Integer.MIN_VALUE;

        for (int val : bloomDay) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }

        long result = -1;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (checkPossibility(mid, bloomDay, m, k)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) result;
    }

    private static boolean checkPossibility(long day, int[] bloomDay, int m, int k) {
        int bouquets = 0;
        int consecutive = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }

        return bouquets >= m;

    }

    public static void main(String[] args) {
        int[] bloomDay = {1000000000, 1000000000};
        System.out.println(minDays(bloomDay, 1, 1));
    }
}
