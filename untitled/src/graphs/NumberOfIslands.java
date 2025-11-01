package graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Anirudh
 * @since 29/10/25
 */
public class NumberOfIslands {


    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;

        boolean[][] visited = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    bfs(visited, grid, row, col);
                    islands++;
                }
            }
        }
        return islands;

    }

    private static void bfs(boolean[][] visited, char[][] grid, int row, int col) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.pop();

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    if (Math.abs(delRow) + Math.abs(delCol) != 1) continue;
                    int nrow = delRow + r;
                    int ncol = delCol + c;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == '1') {
                        visited[nrow][ncol] = true;
                        q.push(new Pair(nrow, ncol));
                    }


                }
            }
        }
    }
}

class Pair {
    int first;
    int third;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return first == p.first && second == p.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    int second;

}
