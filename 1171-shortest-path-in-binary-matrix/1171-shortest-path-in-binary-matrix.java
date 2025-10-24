class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int dirct[][] = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1},  {1, 0}, {1, 1}
        };

        Queue<int[]> qu = new LinkedList<>();

        qu.add(new int[]{0, 0 , 1});

        grid[0][0] = 1;

        while (!qu.isEmpty()) {

            int[] node = qu.poll();

            int r = node[0];
            int c = node[1];
            int len = node[2];

            if (r == n - 1 && c == n - 1) return len;

            for (int[] dir: dirct) {
                
                int row = r + dir[0];
                int col = c + dir[1];

                if (
                    row >= 0 && row < n &&
                    col >= 0 && col < n &&
                    grid[row][col] == 0
                ) {
                    qu.add(new int[] {row, col, len + 1});

                    grid[row][col] = 1;
                }
            }
        }

        return -1;
    }
}