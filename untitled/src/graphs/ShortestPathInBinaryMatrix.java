package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Anirudh
 * @since 08/04/26
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int INF = (int) 1e9;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        dist[0][0] = 1;
        // row, col, dist
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((int[] ar) -> ar[2]));

        q.offer(new int[]{0, 0, 1});

        int[] delRow = {-1, 0, 1, 0, -1, 1, -1, 1};
        int[] delCol = {0, 1, 0, -1, -1, -1, 1, 1};

        while (!q.isEmpty()) {
            int[] polled = q.poll();

            int row = polled[0];
            int col = polled[1];
            int currDist = polled[2];

            if (row == n - 1 && col == m - 1)
                return currDist;

            for (int i = 0; i < 8; i++) {
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0 && dist[nr][nc] > 1 + currDist) {
                    dist[nr][nc] = 1 + currDist;
                    q.offer(new int[]{nr, nc, currDist + 1});
                }
            }


        }

        return dist[n - 1][m - 1] == INF ? -1 : dist[n - 1][m - 1];
    }
}
