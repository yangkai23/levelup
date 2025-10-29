package graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Anirudh
 * @since 29/10/25
 */
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Deque<Cell> deque = new ArrayDeque<>();
        int freshOranges = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new Cell(i, j, 0));
                    visited[i][j] = 2;
                }
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        int tm = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int oneCount = 0;
        while (!deque.isEmpty()) {
            int r = deque.peek().row;
            int c = deque.peek().col;
            int time = deque.peek().time;
            tm = Math.max(tm, time);
            deque.pop();
            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] != 2) {
                    visited[nrow][ncol] = 2;
                    deque.add(new Cell(nrow, ncol, time + 1));
                    oneCount++;
                }


            }
        }
        if (freshOranges != oneCount)
            return -1;
        return tm;
    }
}

class Cell {
    int row;
    int col;
    int time;

    public Cell(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
