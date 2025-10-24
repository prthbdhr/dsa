class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    qu.add(new int[]{i, j, 0}); 
                    vis[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, +1, 0, -1};

        while (!qu.isEmpty()) {

            int[] node = qu.poll();
            int row = node[0];
            int col = node[1];
            int steps = node[2];

            res[row][col] = steps;

            for (int i = 0; i < 4; i++) {

                int r = row + dr[i];
                int c = col + dc[i];

                if (r >= 0 && r < m && c >= 0 && c < n && !vis[r][c]) {

                    vis[r][c] = true;

                    qu.offer(new int[]{r, c, steps + 1});
                }
            }
        }

        return res;
    }
}