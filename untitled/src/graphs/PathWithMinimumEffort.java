package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Anirudh
 * @since 06/12/25
 */
public class PathWithMinimumEffort {

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing((int[] ar)->ar[0]));
        heap.offer(new int[]{0, 0, 0});

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while (!heap.isEmpty()) {
            int[] polled = heap.poll();
            int currDist = polled[0];
            int row = polled[1];
            int col = polled[2];

            if (row == n - 1 && col == m - 1) {
                return currDist;
            }
            for (int i = 0; i < 4; i++) {
                int r = delRow[i] + row;
                int c = delCol[i] + col;
                if (r >= 0 && r < n && c >= 0 && c < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[r][c]), currDist);
                    if (newEffort < dist[r][c]) {
                        dist[r][c] = newEffort;
                        heap.offer(new int[]{newEffort, r, c});
                    }
                }
            }
        }
        return 0;
    }
}
