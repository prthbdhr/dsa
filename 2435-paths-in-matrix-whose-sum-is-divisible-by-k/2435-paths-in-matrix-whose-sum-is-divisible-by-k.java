class Solution {

    private static final int MOD = 1_000_000_007;

    int m, n, k;
    int[][] grid;
    long[][][] dp; // -1 => uncomputed

    public int numberOfPaths(int[][] grid, int k) {
        
        this.grid = grid;
        this.k = k;
        this.m = grid.length;
        this.n = grid[0].length;

        this.dp = new long[m][n][k];

        // Base cell (0,0)
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                int val = grid[i][j] % k;

                for (int rem = 0; rem < k; rem++) {
                    
                    int prev = (rem - val + k) % k;

                    long fromTop  = (i > 0) ? dp[i - 1][j][prev] : 0;
                    long fromLeft = (j > 0) ? dp[i][j - 1][prev] : 0;

                    dp[i][j][rem] = (fromTop + fromLeft) % MOD;
                }
            }
        }

       return (int) dp[m - 1][n - 1][0];
    }
}