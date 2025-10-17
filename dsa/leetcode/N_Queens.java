/**
 *  #Leetcode 51 | https://leetcode.com/problems/n-queens
 */

public class N_Queens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String >> res = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve ( 0, board, res, leftRow, upperDiagonal, lowerDiagonal, n);

        return res;
    }

    private void solve (int col, char[][] board, List<List<String >> res, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int n) {
        if (col == n) {

            res.add(construct(board));

            return;
        }

        for (int i = 0; i < n; i++) {
            if (leftRow[i] == 0 && upperDiagonal[(n - 1) + (col - i)] == 0 && lowerDiagonal[col + i] == 0) {
                leftRow[i] = 1;
                upperDiagonal[(n - 1) + (col - i)] = 1;
                lowerDiagonal[col + i] = 1;
                board[i][col] = 'Q';

                solve(col + 1, board, res, leftRow, upperDiagonal, lowerDiagonal, n);

                leftRow[i] = 0;
                upperDiagonal[(n - 1) + (col - i)] = 0;
                lowerDiagonal[col + i] = 0;
                board[i][col] = '.';
            }
        }

        return;
    }

    private List<String > construct(char[][] board) {
        List<String> ans = new ArrayList<>(board.length);
        StringBuilder sb = new StringBuilder(board.length);

        for (char[] row : board) {
            sb.setLength(0);
            for (char c : row) {
                sb.append(c);
            }
            ans.add(sb.toString());
        }

        return ans;
    }
}