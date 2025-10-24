class Solution {
    public void solve(char[][] board) {
        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int j = 0; j < n; j++) {

            if (!vis[0][j] && board[0][j] == 'O') dfs(0, j, board, vis, dr, dc, m, n);

            if (!vis[m - 1][j] && board[m - 1][j] == 'O') dfs(m - 1, j, board, vis, dr, dc, m, n);
        }

        for (int i = 0; i < m; i++) {
            
            if (!vis[i][0] && board[i][0] == 'O') dfs(i, 0, board, vis, dr, dc, m, n);

            if (!vis[i][n - 1] && board[i][n - 1] == 'O') dfs(i, n - 1, board, vis, dr, dc, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!vis[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        return;
    }

    private void dfs (int row, int col, char[][] board, boolean[][] vis, int[] dr, int[] dc, int m, int n) {

        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {

            int r = row + dr[i];
            int c = col + dc[i];

            if ( isDfsAble(r, c, vis, board, m, n)) dfs(r, c, board, vis, dr, dc, m, n);
        }

        return;
    }

    private boolean isDfsAble(int r, int c, boolean[][] vis, char[][] board, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n && !vis[r][c] && board[r][c] == 'O';
    }
}