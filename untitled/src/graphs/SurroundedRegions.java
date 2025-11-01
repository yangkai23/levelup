package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * @author Anirudh
 * @since 30/10/25
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        String[][] board = {{"O", "X", "X", "O", "X"},
                {"X", "O", "O", "X", "O"},
                {"X", "O", "X", "O", "X"},
                {"O", "X", "O", "O", "O"},
                {"X", "X", "O", "X", "O"}};

        char[][] result = Arrays.stream(board)
                .map(row -> Arrays.stream(row)
                        .map(s -> s.charAt(0))
                        .collect(StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append)
                        .toString()
                        .toCharArray())
                .toArray(char[][]::new);
        solve(result);

    }

    public static void solve(char[][] board) {
        Deque<Pair> q = new ArrayDeque<>();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O')
                q.add(new Pair(0, i));
            if (board[n - 1][i] == 'O')
                q.add(new Pair(n - 1, i));
        }
        for (int i = 1; i < n-1; i++) {
            if (board[i][0] == 'O')
                q.add(new Pair(i, 0));
            if (board[i][m - 1] == 'O')
                q.add(new Pair(i, m - 1));
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        while (!q.isEmpty()) {

            Pair p = q.pop();
            int r = p.first;
            int c = p.second;
            board[r][c] = 'M';
            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] != 'X' && board[nrow][ncol] == 'O' && board[nrow][ncol]!='M') {
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'M')
                    board[i][j] = 'O';

            }
        }
    }
}
