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
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                Arrays.fill(dp[i][j], -1L);
            }
        }

        return (int) solve(m - 1, n - 1, 0);
    }

    private long solve(int r, int c, int rem) {

        if (r < 0 || c < 0) return 0;

        long cached = dp[r][c][rem];

        if (cached != -1) return cached;

        int val = ((grid[r][c] % k) + k) % k;

        if (r == 0 && c == 0) {

            dp[r][c][rem] = (rem == val) ? 1L : 0L;

            return dp[r][c][rem];
        }

        int prev = (rem - val + k) % k;

        long waysFromTop = solve(r - 1, c, prev);
        long waysFromleft = solve(r, c- 1, prev);

        long ans = (waysFromTop + waysFromleft) % MOD;

        return dp[r][c][rem] = ans;
    }
}