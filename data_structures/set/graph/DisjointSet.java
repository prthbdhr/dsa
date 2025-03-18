import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor to initialize the disjoint set data structure
    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) { // Using 0-based indexing
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    // Find the representative of the set to which 'node' belongs
    public int findUPar(int node) {
        if (node != parent.get(node)) {
            parent.set(node, findUPar(parent.get(node))); // Path compression
        }
        return parent.get(node);
    }

    // Union by rank: Attach smaller rank tree under root of deeper tree
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    // Union by size: Attach smaller tree under root of larger tree
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
