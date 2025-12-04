package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anirudh
 * @since 04/12/25
 */
public class ShortestDistanceInABinaryMaze {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        int[] source = {0, 1};
        int[] destination = {2, 2};
        System.out.println(shortestPath(grid, source, destination));
    }

    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        if (source[0] == destination[0] && source[1] == destination[1]) return 0;
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, source[0], source[1]});
        dist[source[0]][source[1]] = 0;

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int currDist = polled[0];
            int row = polled[1];
            int col = polled[2];
            for (int i = 0; i < 4; i++) {
                int r = delRow[i] + row;
                int c = delCol[i] + col;

                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] != 0) {
                    if (r == destination[0] && c == destination[1]) {
                        return currDist + 1;
                    }
                    if (dist[r][c] > (currDist) + 1) {
                        dist[r][c] = currDist + 1;
                        q.offer(new int[]{currDist + 1, r, c});
                    }
                }
            }
        }

        return -1;
    }
}
