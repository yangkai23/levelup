package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 10/12/25
 */
public class NumberOfIslandsII {
    public static void main(String[] args) {
        int[][] arr = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1}, {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}};
        System.out.println(numOfIslands(4, 5, arr));

    }

    public static List<Integer> numOfIslands(int n, int m, int[][] A) {
        int[][] mat = new int[n][m];
        DisjointSet ds = new DisjointSet(n * m);
        List<Integer> ans = new ArrayList<>();
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int islands = 0;
        for (int[] cell : A) {
            if (mat[cell[0]][cell[1]] == 1) {
                ans.add(islands);
                continue;
            }
            mat[cell[0]][cell[1]] = 1;
            islands++;
            for (int i = 0; i < 4; i++) {
                int r = cell[0] + delRow[i];
                int c = cell[1] + delCol[i];
                if (r >= 0 && r < n && c >= 0 && c < m && mat[r][c] == 1) {
                    int adjCellNum = (r * m) + c;
                    int currCell = (cell[0] * m) + cell[1];
                    if (ds.unionBySize(currCell, adjCellNum))
                        islands--;
                }
            }
            ans.add(islands);
        }
        return ans;
    }
}
