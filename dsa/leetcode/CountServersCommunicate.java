/**
 *  Leetcode 1267 | https://leetcode.com/problems/count-servers-that-communicate
 */

public class CountServersCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (colCount[j] > 1 || rowCount[i] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}