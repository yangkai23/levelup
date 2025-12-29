package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 29/10/25
 */
public class _01Matrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println(Arrays.deepToString(updateMatrix(grid)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Deque<Pair> deque = new ArrayDeque<>();
        Collections.binarySearch(new ArrayList<>(),0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    deque.add(new Pair(i, j, 0));
                }

            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while (!deque.isEmpty()) {
            Pair popped = deque.pop();
            int r = popped.first;
            int c = popped.second;
            int dist = popped.third;


            ans[r][c] = dist;
            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] == 1 && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    deque.add(new Pair(nrow, ncol, dist + 1));
                }
            }
        }
        return ans;
    }
}

