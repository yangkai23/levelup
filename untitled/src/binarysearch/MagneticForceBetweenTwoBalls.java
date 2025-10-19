package binarysearch;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 19/10/25
 */
public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {79,74,57,22};
        System.out.println(maxDistance(position, 4));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        long low = 1;
        long high = position[n - 1] - position[0];
        long result = 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (checkBallsPlacement(position, m, mid)) {
                result = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return (int) result;
    }

    private static boolean checkBallsPlacement(int[] position, int m, long dist) {
        int result = 1;
        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= dist) {
                result++;
                last = position[i];
            }
        }
        return result >= m;
    }
}
