package recursion;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Anirudh
 * @since 18/12/25
 * Solves the classic N-Queens problem using backtracking.
 * Problem:
 * Place N queens on an N x N chessboard such that:
 * - No two queens share the same row
 * - No two queens share the same column
 * - No two queens share the same diagonal
 * Approach:
 * This solution places queens column by column using backtracking.
 * To efficiently check whether a queen can be placed at a given cell,
 * three boolean arrays are used:
 * 1. leftRow[row]
 * - Tracks whether a queen already exists in a given row.
 * 2. lowerDiagonal[row + col]
 * - Tracks the lower (↙) diagonals.
 * - Cells sharing the same (row + col) belong to the same diagonal.
 * 3. upperDiagonal[(n - 1) + col - row]
 * - Tracks the upper (↖) diagonals.
 * - Offset (n - 1) is added to avoid negative indices.
 * No need to check the right side since queens are placed column by column
 * from left to right (0 → n-1), and the right side is not yet filled.
 * Board Representation:
 * - The board is represented using a List of StringBuilder,
 * allowing efficient in-place updates during backtracking.
 * - 'Q' represents a queen.
 * - '.' represents an empty cell.
 * Backtracking:
 * - For each column, try placing a queen in every row that is safe.
 * - Mark the corresponding row and diagonals as occupied.
 * - Recurse to the next column.
 * - After returning, undo the placement (backtrack) and try other options.
 * Base Case:
 * - When all columns are filled (col == n),
 * the current board configuration is converted to a List<String>
 * and added to the result.
 * Time Complexity:
 * - O(N!), since each column explores possible row placements.
 * Space Complexity:
 * - O(N^2) for storing board configurations.
 * - O(N) for row and diagonal tracking arrays.
 */
public class NQueens {

    /**
     * Initializes the board and auxiliary data structures,
     * and starts the backtracking process.
     *
     * @param n number of queens / size of the board
     * @return all valid N-Queens solutions
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        // Initialize empty board
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(n));
            board.add(sb);
        }

        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];

        solve(0, board, leftRow, lowerDiagonal, upperDiagonal, ans);
        return ans;
    }

    /**
     * Recursive helper method that places queens column by column.
     *
     * @param col           current column to place the queen
     * @param board         current board state
     * @param leftRow       tracks occupied rows
     * @param lowerDiagonal tracks occupied lower diagonals (↙)
     * @param upperDiagonal tracks occupied upper diagonals (↖)
     * @param ans           list of all valid solutions
     */
    private static void solve(int col, List<StringBuilder> board, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal, List<List<String>> ans) {

        // All columns are filled -> valid solution found
        if (col == board.size()) {
            List<String> solution = new ArrayList<>();
            for (StringBuilder row : board) {
                solution.add(row.toString());
            }
            ans.add(solution);
            return;
        }

        // Try placing queen in each row of the current column
        for (int row = 0; row < board.size(); row++) {

            if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[board.size() - 1 + col - row]) {

                // Place queen
                board.get(row).setCharAt(col, 'Q');
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[board.size() - 1 + col - row] = true;

                // Recurse for next column
                solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, ans);

                // Backtrack
                board.get(row).setCharAt(col, '.');
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[board.size() - 1 + col - row] = false;
            }
        }
    }
}

