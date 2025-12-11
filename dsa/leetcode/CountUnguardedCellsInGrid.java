/*
 * #LeetCode 2257 | https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 */

public class CountUnguardedCellsInGrid { 

    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] grid = new int[m][];

        // marking guards 
        for (int[] guard : guards) grid[guard[0]][guard[1]] = GUARD;

        // marking walls
        for (int[] wall : walls) grid[wall[0]][wall[1]] = WALL;

        // marking guarded cells
        for (int[] guard : guards) markDown(guard[0], guard[1], grid);

        // counting unguarded cells
        int unguardedCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == UNGUARDED) unguardedCount++;
            }
        }

        return unguardedCount;
    }

    private void markDown(int row, int col, int[][] grid) {

        
    }
}
