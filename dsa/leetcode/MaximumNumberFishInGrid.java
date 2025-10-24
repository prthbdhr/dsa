/**
 *  #Leetcode 2658 | https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
 */

public class MaximumNumberFishInGrid {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxFish = 0;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] > 0 && !vis[i][j]) {
                   int countFish = dfs(grid, vis, i, j, n, m);

                   maxFish = Math.max(maxFish, countFish);
                }
            }
        }

        return maxFish;
    }

    private int dfs (int[][] grid, boolean[][] vis,int r, int c, int n, int m) {
        if (
                r < 0 || r >= n ||
                c < 0 || c >= m ||
                vis[r][c] ||
                grid[r][c] == 0
        ) {
            return 0;
        }

        vis[r][c] = true;

        return (
                grid[r][c] +
                dfs(grid, vis, r + 1, c, n, m) +
                dfs(grid, vis, r - 1, c, n, m) +
                dfs(grid, vis, r, c + 1, n, m) +
                dfs(grid, vis, r, c - 1, n, m)
                );
    }
}