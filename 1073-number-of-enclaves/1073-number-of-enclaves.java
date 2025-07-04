class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {

                    if (!vis[i][j] && grid[i][j] == 1) {

                        vis[i][j] = true;

                        qu.add(new int[]{i, j});
                    }
                }
            }
        }

        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};

        while (!qu.isEmpty()) {

            int[] node = qu.poll();
            int row = node[0];
            int col = node[1];

            for (int i = 0; i < 4; i++) {

                int r = row + dr[i];
                int c = col + dc[i];

                if (r >= 0 && r < m && c >= 0 && c < n && !vis[r][c] && grid[r][c] == 1){

                    qu.add(new int[]{r, c});

                    vis[r][c] = true;
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(!vis[i][j] && grid[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }
}