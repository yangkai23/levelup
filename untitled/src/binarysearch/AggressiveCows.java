package binarysearch;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 29/11/25
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {2, 12, 11, 3, 26, 7};
        System.out.println(aggressiveCows(stalls, 5));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int maxDist = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cowsRemaining = checkIfWeCanPlace(mid, stalls, k);
            if (cowsRemaining == 0) {
                maxDist = Math.max(maxDist, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return maxDist;
    }

    private static int checkIfWeCanPlace(int dist, int[] stalls, int k) {
        k--;
        int lastCowPlaced = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if ((stalls[i] - lastCowPlaced) >= dist) {
                lastCowPlaced = stalls[i];
                k--;
            }
            if (k == 0) return 0;
        }
        return k;
    }
}
