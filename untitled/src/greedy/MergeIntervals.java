package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Anirudh
 * @since 29/01/26
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();

        int n = intervals.length;

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][2]);
    }

    public static int[][] merge1(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // index of last merged interval
        int idx = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[idx][1] >= intervals[i][0]) {
                // merge
                intervals[idx][1] = Math.max(intervals[idx][1], intervals[i][1]);
            } else {
                idx++;
                intervals[idx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, idx + 1);
    }
}
