package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 01/11/25
 */
public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}
                , {1, 0, 0, 0, 0}
                , {0, 0, 0, 0, 1}
                , {1, 1, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));
    }

    static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<List<Pair>> set = new HashSet<>();
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j]==1) {
                    set.add(dfs(visited, grid, i, j, new Pair(i, j), new ArrayList<>(), delRow, delCol));
                }

            }
        }
        return set.size();
    }

    private static List<Pair> dfs(boolean[][] visited, int[][] grid, int row, int col, Pair base, List<Pair> pairList, int[] delRow, int[] delCol) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        pairList.add(new Pair(row-base.first, col-base.second));
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == 1)
                dfs(visited, grid, nrow, ncol, base, pairList, delRow, delCol);
        }
        return pairList;
    }


}
