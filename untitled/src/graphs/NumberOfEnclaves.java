package graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Anirudh
 * @since 01/11/25
 */
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        Deque<Pair> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1){
                grid[0][i] = -1;
                q.add(new Pair(0, i));
            }

            if (grid[n - 1][i] == 1){
                grid[n-1][i] = -1;
                q.add(new Pair(n - 1, i));
            }

        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][0] == 1){
                grid[i][0] = -1;
                q.add(new Pair(i, 0));
            }

            if (grid[i][m - 1] == 1){
                grid[i][m-1] = -1;
                q.add(new Pair(i, m - 1));
            }

        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        while (!q.isEmpty()) {

            Pair p = q.pop();
            int r = p.first;
            int c = p.second;
            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                    grid[nrow][ncol]=-1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        int count = 0;
        for (int i=1;i<n-1;i++) {
            for (int j = 1; j < m-1; j++) {
                if (grid[i][j] == 1)
                    count++;

            }
        }
        return count;
    }
}
