package recursion;

/**
 * @author Anirudh
 * @since 20/12/25
 */
public class SudokuSolver {
    /**
     * Solves the Sudoku puzzle in-place using backtracking.
     * <p>
     * Optimization:
     * Instead of scanning rows, columns, and boxes repeatedly,
     * we maintain three boolean hash arrays to track used digits.
     * <p>
     * Time:
     * - Backtracking with O(1) validity checks
     * <p>
     * Space:
     * - O(1) extra space (fixed 9x10 boolean arrays)
     */
    public static void solveSudoku(char[][] board) {

        // rowUsed[r][d] = true if digit d is already used in row r
        boolean[][] rowUsed = new boolean[9][10];

        // colUsed[c][d] = true if digit d is already used in column c
        boolean[][] colUsed = new boolean[9][10];

        // boxUsed[b][d] = true if digit d is already used in 3x3 box b
        boolean[][] boxUsed = new boolean[9][10];

        // Initialize state from the given board
        init(board, rowUsed, colUsed, boxUsed);

        // Start backtracking from the first cell
        solve(board, 0, 0, rowUsed, colUsed, boxUsed);
    }

    /**
     * Initializes rowUsed, colUsed, and boxUsed arrays
     * based on the digits already present in the board.
     */
    private static void init(
            char[][] board,
            boolean[][] rowUsed,
            boolean[][] colUsed,
            boolean[][] boxUsed) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    int d = board[i][j] - '0';

                    // Map (i, j) to its 3x3 box index
                    int box = (i / 3) * 3 + (j / 3);

                    rowUsed[i][d] = true;
                    colUsed[j][d] = true;
                    boxUsed[box][d] = true;
                }
            }
        }
    }

    /**
     * Recursive backtracking function to fill the Sudoku board.
     *
     * @param row starting row index for scanning
     * @param col starting column index for scanning
     * @return true if the board can be solved from this state
     */
    private static boolean solve(
            char[][] board,
            int row,
            int col,
            boolean[][] rowUsed,
            boolean[][] colUsed,
            boolean[][] boxUsed) {

        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {

                // Find the next empty cell
                if (board[i][j] == '.') {

                    // Try placing digits 1 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        int d = c - '0';
                        int box = (i / 3) * 3 + (j / 3);

                        // O(1) validity check using hash arrays
                        if (!rowUsed[i][d] && !colUsed[j][d] && !boxUsed[box][d]) {

                            // Place digit
                            board[i][j] = c;
                            rowUsed[i][d] = true;
                            colUsed[j][d] = true;
                            boxUsed[box][d] = true;

                            // Move to the next cell
                            int nextRow = (j == 8) ? i + 1 : i;
                            int nextCol = (j == 8) ? 0 : j + 1;

                            if (solve(board, nextRow, nextCol, rowUsed, colUsed, boxUsed)) {
                                return true;
                            }

                            // Backtrack (undo choice)
                            board[i][j] = '.';
                            rowUsed[i][d] = false;
                            colUsed[j][d] = false;
                            boxUsed[box][d] = false;
                        }
                    }

                    // No valid digit fits in this cell
                    return false;
                }
            }

            // Important: reset column when moving to the next row while iterating on the same level
            col = 0;
        }

        // All cells filled successfully
        return true;
    }

    /**
     * Checks whether a given digit can be placed at (row, col)
     * by scanning:
     * - the entire row
     * - the entire column
     * - the corresponding 3x3 sub-box
     * <p>
     * Time Complexity:
     * - O(9) per check (constant, but repeated many times)
     * <p>
     * Note:
     * This method is NOT used in the optimized solution
     * that relies on boolean hash arrays (rowUsed, colUsed, boxUsed).
     * <p>
     * It is kept here for reference and comparison.
     */
    private static boolean valid(char[][] board, char num, int row, int col) {

        for (int i = 0; i < 9; i++) {

            // Check if the number already exists in the row
            if (board[row][i] == num)
                return false;

            // Check if the number already exists in the column
            if (board[i][col] == num)
                return false;

            // Check if the number exists in the 3x3 sub-box
            int boxRow = 3 * (row / 3) + (i / 3);
            int boxCol = 3 * (col / 3) + (i % 3);

            if (board[boxRow][boxCol] == num)
                return false;
        }

        return true;
    }


}
