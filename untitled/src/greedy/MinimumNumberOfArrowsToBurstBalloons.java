package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anirudh
 * @since 07/10/25
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(ar -> ar[1]));

        int numOfArrows = 1;
        int lastArrow = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastArrow) {
                numOfArrows++;
                lastArrow = points[i][1];
            }
        }

        return numOfArrows;
    }
}
