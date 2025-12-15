package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Anirudh
 * @since 11/12/25
 */
public class MakingALargeIsland {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}};
        System.out.println(largestIsland(grid));
    }

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    int node = i * n + j;

                    for (int k = 0; k < 4; k++) {
                        int row = i + delRow[k];
                        int col = j + delCol[k];

                        if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 1) {
                            ds.unionBySize(node, row * n + col);
                        }
                    }
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int area = 1;

                    for (int k = 0; k < 4; k++) {
                        int row = i + delRow[k];
                        int col = j + delCol[k];

                        if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 1) {
                            int root = ds.findUltimateParent(row * n + col);
                            if (seen.add(root)) {
                                area += ds.size.get(root);
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        if (maxArea == 0) {
            for (int i = 0; i < n * n; i++) {
                if (i == ds.findUltimateParent(i)) {
                    maxArea = Math.max(maxArea, ds.size.get(i));
                }
            }
        }

        return maxArea;
    }

}
