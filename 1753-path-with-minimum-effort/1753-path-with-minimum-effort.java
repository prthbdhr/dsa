class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] dis = new int[m][n];

        PriorityQueue<int[]> qu = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        qu.offer(new int[]{0, 0, 0});

        for (int[] d: dis) Arrays.fill(d, (int) 1e9);

        dis[0][0] = 0;

        while (!qu.isEmpty()) {

            int[] poll = qu.poll();

            int row = poll[0];
            int col = poll[1];
            int wt = poll[2];

            if (row == m - 1 && col == n - 1) return wt;

            for (int i = 0; i < 4; i++) {

                int r = row + dr[i];
                int c = col + dc[i];

                if (r < m && r >= 0 && c < n && c >= 0) {

                    int curDis = Math.max(wt, Math.abs(heights[r][c] - heights[row][col]));

                    if (curDis < dis[r][c]) {

                        dis[r][c] = curDis;

                        qu.add(new int[]{r, c, curDis});
                    }
                }
            }
        }

        return -1;
    }
}