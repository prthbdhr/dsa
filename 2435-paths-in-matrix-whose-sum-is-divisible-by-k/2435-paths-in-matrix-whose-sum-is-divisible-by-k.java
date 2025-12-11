import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // prev -> dp values for previous row
        // curr -> dp values for current row being computed
        long[][] prev = new long[n][k];
        long[][] curr = new long[n][k];

        for (int i = 0; i < m; i++) {
            // reset curr for the new row
            for (int x = 0; x < n; x++) {
                Arrays.fill(curr[x], 0L);
            }

            for (int j = 0; j < n; j++) {
                int val = ((grid[i][j] % k) + k) % k;

                if (i == 0 && j == 0) {
                    // base cell
                    curr[j][val] = 1;
                    continue;
                }

                for (int rem = 0; rem < k; rem++) {
                    int prevMod = (rem - val + k) % k;

                    long fromTop = (i > 0) ? prev[j][prevMod] : 0L;
                    long fromLeft = (j > 0) ? curr[j - 1][prevMod] : 0L;

                    curr[j][rem] = (fromTop + fromLeft) % MOD;
                }
            }

            // move current row into prev for next iteration
            long[][] tmp = prev;
            prev = curr;
            curr = tmp; // reuse the array buffer (we'll zero it at loop start)
        }

        // after last row processed, prev holds the final row
        return (int) prev[n - 1][0];
    }
}
