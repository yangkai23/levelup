package daily;

/**
 * @author Anirudh
 * @since 02/11/25
 */
public class CountUnguardedCellsInTheGrid {
    public static void main(String[] args) {
            int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
            int[][] walls = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(countUnguarded(4, 6, guards, walls));
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int temp = m;
        m = n;
        n = temp;
        int[][] grid = new int[n][m];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            if (row < n - 1) {
                for (int i = row + 1; i < n; i++) {
                    if (grid[i][col] == 0 || grid[i][col] == 3) {
                        grid[i][col] = 3;
                    } else
                        break;
                }
            }
            if (row > 0) {
                for (int i = row - 1; i >= 0; i--) {
                    if (grid[i][col] == 0 || grid[i][col] == 3) {
                        grid[i][col] = 3;
                    } else
                        break;
                }
            }
            if (col > 0) {
                for (int i = col - 1; i >= 0; i--) {
                    if (grid[row][i] == 0 || grid[row][i] == 3) {
                        grid[row][i] = 3;
                    } else
                        break;
                }
            }
            if (col < m - 1) {
                for (int i = col + 1; i < m; i++) {
                    if (grid[row][i] == 0 || grid[row][i] == 3) {
                        grid[row][i] = 3;
                    } else
                        break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}
