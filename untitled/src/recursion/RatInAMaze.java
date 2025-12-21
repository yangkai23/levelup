package recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anirudh
 * @since 20/12/25
 */
public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};

        System.out.println(ratInMaze(maze));
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;

        boolean[][] visited = new boolean[n][n];

        ArrayList<String> ans = new ArrayList<>();
        int[] delRow = {1, 0, 0, -1};
        int[] delCol = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        findPath(n, maze, visited, ans, delRow, delCol, dir, 0, 0, new StringBuilder());

        return ans;

    }

    private static void findPath(int n, int[][] maze, boolean[][] visited, ArrayList<String> ans,
                                 int[] delRow, int[] delCol, char[] dir, int row, int col, StringBuilder sb) {

        if (row == n - 1 && col == n - 1) {
            ans.add(sb.toString());
            return;
        }
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n
                    && !visited[nRow][nCol] && maze[nRow][nCol] == 1) {

                sb.append(dir[i]);
                findPath(n, maze, visited, ans, delRow, delCol, dir, nRow, nCol, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        visited[row][col] = false;

    }


}
