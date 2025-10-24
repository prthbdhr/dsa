/**
 *  #Leetcode 827 | https://leetcode.com/problems/making-a-large-island
 */
public class MakingALargeIsland {

    private boolean isValid(int r, int c, int n) {
        return (r >= 0 && r < n && c >= 0 && c < n);
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        DisjointSet ds = new DisjointSet(n* n);

        int[][] dirct = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) continue;

                for (int[] dir: dirct) {

                    int row = i + dir[0];
                    int col = j + dir[1];

                    if (isValid(row, col, n) && grid[row][col] == 1) {

                        int node = i * n + j;
                        int newNode = row * n + col;

                        ds.unionBySize(node, newNode);
                    }
                }
            }
        }

        int maxi = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) maxi = Math.max(maxi, ds.size.get(ds.findRoot(i * n + j)));

                else {

                    hasZero = true;

                    Set<Integer> components = new HashSet<>();

                    for (int[] dir: dirct) {

                        int row = i + dir[0];
                        int col = j + dir[1];

                        if (isValid(row, col, n) && grid[row][col] == 1) components.add(ds.findRoot(row * n + col));
                    }

                    int size = 1;

                    for (Integer parent: components) size += ds.size.get(parent);

                    maxi = Math.max(maxi, size);
                }
            }
        }

        return hasZero ? maxi : n * n;

    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor to initialize the disjoint set data structure
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    // Find the representative of the set to which 'node' belongs
    public int findRoot(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        // Path compression
        int uRoot = findRoot(parent.get(node));
        parent.set(node, uRoot);
        return parent.get(node);
    }

    // Union by size: Attach smaller tree under root of larger tree
    public void unionBySize(int u, int v) {
        int uRoot = findRoot(u);
        int vRoot = findRoot(v);
        if (uRoot == vRoot) return;

        if (size.get(uRoot) < size.get(vRoot)) {
            parent.set(uRoot, vRoot);
            size.set(vRoot, size.get(vRoot) + size.get(uRoot));
        } else {
            parent.set(vRoot, uRoot);
            size.set(uRoot, size.get(uRoot) + size.get(vRoot));
        }
    }
}