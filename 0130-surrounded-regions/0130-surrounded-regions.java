class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] vis = new boolean[m][n];
        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, +1, 0, -1};
        
        // Check first and last row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                dfs(0, j, board, vis, dr, dc, m, n);
            }
            if (board[m - 1][j] == 'O' && !vis[m - 1][j]) {
                dfs(m - 1, j, board, vis, dr, dc, m, n);
            }
        }
        
        // Check first and last column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, board, vis, dr, dc, m, n);
            }
            if (board[i][n - 1] == 'O' && !vis[i][n - 1]) {
                dfs(i, n - 1, board, vis, dr, dc, m, n);
            }
        }
        
        // Flip remaining 'O's to 'X's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(int row, int col, char[][] board, boolean[][] vis, int[] dr, int[] dc, int m, int n) {
        vis[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int r = row + dr[i];
            int c = col + dc[i];
            
            if (r >= 0 && r < m && c >= 0 && c < n && !vis[r][c] && board[r][c] == 'O') {
                dfs(r, c, board, vis, dr, dc, m, n);
            }
        }
    }
}