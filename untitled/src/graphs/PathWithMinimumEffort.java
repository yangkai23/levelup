package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Anirudh
 * @since 06/12/25
 */
public class PathWithMinimumEffort {

    /**
     * Finds a path from the top-left to the bottom-right cell such that the
     * maximum absolute height difference between adjacent cells along the path
     * is minimized.
     * <p>
     * This problem is solved using a modified version of Dijkstra’s algorithm:
     * - Each cell is treated as a node in a graph.
     * - The "distance" of a path is defined as the maximum edge weight
     * (height difference) encountered so far, instead of the sum.
     * - At each step, we expand the cell with the minimum current effort.
     * <p>
     * Once the destination cell is reached, the effort associated with it
     * is guaranteed to be the minimum possible.
     * <p>
     * Time Complexity: O((n * m) log (n * m))
     * - Each cell can be pushed into the priority queue
     * <p>
     * Space Complexity: O(n * m)
     * - Distance matrix and priority queue
     *
     * @param heights 2D grid representing heights of each cell
     * @return minimum effort required to travel from (0,0) to (n-1,m-1)
     */
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // dist[r][c] stores the minimum effort required to reach cell (r, c)
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        // Min-heap ordered by current effort
        PriorityQueue<int[]> heap =
                new PriorityQueue<>(Comparator.comparing((int[] ar) -> ar[0]));

        // {effort, row, col}
        heap.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!heap.isEmpty()) {
            int[] polled = heap.poll();
            int currDist = polled[0];
            int row = polled[1];
            int col = polled[2];

            // Destination reached with minimum effort
            if (row == n - 1 && col == m - 1) {
                return currDist;
            }

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int r = row + delRow[i];
                int c = col + delCol[i];

                if (r >= 0 && r < n && c >= 0 && c < m) {
                    int newEffort = Math.max(
                            Math.abs(heights[row][col] - heights[r][c]),
                            currDist
                    );

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
