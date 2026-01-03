package dynamicprogramming;

/**
 * @author Anirudh
 * @since 03/01/26
 */
public class CountRoutesToClimbARectangularGrid {

    static final int MOD = 1_000_000_007;

    public static int numberOfRoutes(String[] grid, int d) {

        int n = grid.length;
        int m = grid[0].length();

        long ans = 0;

        for (int i = 0; i < m; i++) {
            if (grid[n - 1].charAt(i) == '#') continue;

            // last move was different row at start
            ans = (ans + fn(n - 1, i, grid, d, false)) % MOD;
        }

        return (int) ans;
    }

    static long fn(int r, int c, String[] grid, int d, boolean lastSameRow) {

        // reached top row
        if (r == 0) return 1;

        long ways = 0;

        if (!lastSameRow) {

            // left
            if (c - 1 >= 0 &&
                    grid[r].charAt(c - 1) == '.' &&
                    distOk(r, c, r, c - 1, d)) {

                ways = (ways + fn(r, c - 1, grid, d, true)) % MOD;
            }

            // right
            if (c + 1 < grid[0].length() &&
                    grid[r].charAt(c + 1) == '.' &&
                    distOk(r, c, r, c + 1, d)) {

                ways = (ways + fn(r, c + 1, grid, d, true)) % MOD;
            }
        }

        // UP MOVE
        if (r - 1 >= 0 &&
                grid[r - 1].charAt(c) == '.' &&
                distOk(r, c, r - 1, c, d)) {

            ways = (ways + fn(r - 1, c, grid, d, false)) % MOD;
        }

        return ways;
    }


    static boolean distOk(int r1, int c1, int r2, int c2, int d) {
        int dr = r1 - r2;
        int dc = c1 - c2;
        return dr * dr + dc * dc <= d * d;
    }

}
