/**
 *  https://www.geeksforgeeks.org/problems/chocolates-pickup/1
 */

public class ChocolatesPickup {

    public int solve(int n, int m, int grid[][]) {

        int[][][] dp = new int[n][m][m];

        for (int[][] x: dp) for (int[] y: x) Arrays.fill(y, -1);

        return memorization(0, 0, m - 1, grid, dp, n, m);
    }

    private int memorization(int r, int c1, int c2, int[][] grid, int[][][] dp, int n, int m) {

        if (c1 < 0 || c1 == m || c2 < 0 || c2 == m) return (int) -1e9;

        if (r == n - 1) {

            if (c1 == c2) return grid[r][c1];

            else return grid[r][c1] + grid[r][c2];
        }

        if (dp[r][c1][c2] != -1) return dp[r][c1][c2];

        int maxi = Integer.MIN_VALUE;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int chocolates;

                if (c1 == c2) chocolates = grid[r][c1] + memorization(r + 1, c1 + d1, c2 + d2, grid, dp, n, m);

                else chocolates = grid[r][c1] + grid[r][c2] + memorization(r + 1, c1 + d1, c2 + d2, grid, dp, n, m);

                maxi = Math.max(maxi, chocolates);
            }
        }

        return dp[r][c1][c2] = maxi;
    }
}