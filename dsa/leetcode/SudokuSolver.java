/**
 *  #Leetcode 37 | https://leetcode.com/problems/sudoku-solver
 */

public class SudokuSolver {

    public void solveSudoku(char[][] board) {

        solve(board);

        return;
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        if (isSafe(c, i, j, board)) {

                            board[i][j] = c;

                            if (solve (board)) return true;

                            else board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(char ch, int r, int c, char[][] board) {
        for (int i = 0; i < 9; i++) {

            if (board[r][i] == ch) return false;

            if (board[i][c] == ch) return false;

            if (board[3 * (r / 3) + (i / 3)][3 * (c / 3) + (i % 3)] == ch) return false;

        }

        return true;
    }
}