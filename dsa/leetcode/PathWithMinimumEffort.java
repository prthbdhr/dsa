/**
 *  #Leetcode 1631 | https://leetcode.com/problems/path-with-minimum-effort/
 */

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dirct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[][] efforts = new int[rows][cols];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[]{0, 0, 0});

        for (int[] ef: efforts) Arrays.fill(ef, (int) 1e9);

        efforts[0][0] = 0;

        while (!pq.isEmpty()) {

            int[] node = pq.poll();

            int row = node[0];
            int col = node[1];
            int effort = node[2];

            if (row == rows && col == cols) return effort;

            for (int[] dir: dirct) {

                int r = row + dir[0];
                int c = col + dir[1];

                if (
                        r >= 0 && r < rows &&
                                c >= 0 && c < cols
                ) {

                    int newEfforts = Math.max(effort, Math.abs(heights[row][col] - heights[r][c]));

                    if (newEfforts < efforts[r][c]) {

                        efforts[r][c] = newEfforts;

                        pq.add(new int[]{r, c, newEfforts});
                    }
                }
            }
        }

        return -1;
    }
}