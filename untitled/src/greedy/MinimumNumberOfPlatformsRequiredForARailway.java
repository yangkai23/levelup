package greedy;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 29/09/25
 */
public class MinimumNumberOfPlatformsRequiredForARailway {
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arrival, departure));
    }

    public static int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int count = 0;
        int i = 0;
        int j = 0;
        int numOfPlatform = 0;

        while (i < Arrival.length) {
            if (Arrival[i] <= Departure[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            numOfPlatform = Math.max(numOfPlatform, count);
        }
        return numOfPlatform;
    }
}
