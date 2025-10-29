package graphs;

/**
 * @author Anirudh
 * @since 29/10/25
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(image[i], 0, ans[i], 0, m);
        }
        int initColor = image[sr][sc];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        dfs(image, ans, sr, sc, color, initColor, delRow, delCol);
        return ans;
    }

    private void dfs(int[][] image, int[][] ans, int sr, int sc, int newColor, int initColor, int[] delRow, int[] delCol) {
        int n = image.length;
        int m = image[0].length;
        ans[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initColor && ans[nrow][ncol] != newColor) {
                dfs(image, ans, nrow, ncol, newColor, initColor, delRow, delCol);
            }
        }
    }

}
