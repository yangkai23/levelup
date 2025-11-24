package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anirudh
 * @since 20/11/25
 */
public class SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        int[][] intervals={{1,3},{3,7},{8,9}};
        System.out.println(intersectionSizeTwo(intervals));
    }
    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] ar) -> ar[1]).thenComparing((int[] ar) -> ar[0],Comparator.reverseOrder()));
        int first = -1;
        int second = -1;
        int result = 0;
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];

            if (l <= first) continue;
            if (l > second) {
                first = r - 1;
                second = r;
                result += 2;
            } else {
                first = second;
                second = r;
                result += 1;
            }
        }
        return result;
    }
}
