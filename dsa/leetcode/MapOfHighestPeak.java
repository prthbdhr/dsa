/**
 *  Leetcode 1765 | https://leetcode.com/problems/map-of-highest-peak
 */

public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int m = isWater.length;
        int n = isWater.length;

        int[][] height = new int[m][n];
        
        for (int[] row: height) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    qu.offer(new int[]{i, j});
                }
            }
        }

            int heightOfNextLayer = 1;

            while (!qu.isEmpty()) {
                int size = qu.size();

                for (int i = 0; i < size; i++) {
                    int[] cell = qu.poll();
                    int row = cell[0];
                    int col = cell[1];

                    for (int d = 0; d < dx.length; d++) {
                        int neighborOfRow = row + dx[d];
                        int neighborOfCol = col + dy[d];

                        if (isValidCell(neighborOfRow, neighborOfCol, m, n) && height[neighborOfRow][neighborOfCol] == -1) {
                            height[neighborOfRow][neighborOfCol] = heightOfNextLayer;
                            qu.offer(new int[] {neighborOfRow, neighborOfCol});
                        }
                    }
                }

                heightOfNextLayer++;
            }

            return height;
    }

    private boolean isValidCell (int r, int c, int m, int n) {
        return ( r >= 0 && c >= 0 && r < m && c < n);
    }
}