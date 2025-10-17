/**
 *  https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
 */

public class M_ColoringProblem {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[v];

        return solve (0, color, adj, v, m);
    }

    boolean solve (int vertex, int[] color, List<List<Integer>> adj, int v, int m) {
        if (vertex == v) return true;

        for (int c = 1; c <= m; i++) {
            if (safeVertex(vertex, adj, color, c)) {
                color[vertex] = c;

                if (solve(vertex + 1, color, adj, v, m)) return true;

                color[vertex] = 0;
            }
        }

        return false;
    }

    boolean safeVertex(int vertex, List<List<Integer>> adj, int[] color, int c) {
        for (int neighbor: adj.get(vertex)) {
            if (color[neighbor] == c) return false;
        }

        return true;
    }
}