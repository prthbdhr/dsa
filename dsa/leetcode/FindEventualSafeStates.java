/**
 *  #Leetcode 802 | https://leetcode.com/problems/find-eventual-safe-states/
 */

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        boolean[] visited = new boolean[n];

        boolean[] inStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(graph, i, visited, inStack);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!inStack[i]) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs (int[][] graph, int node, boolean[] visited, boolean[] inStack) {

        if (inStack[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        inStack[node] = true;

        for (int neighbor: graph[node]) {
            if (dfs(graph, neighbor, visited, inStack)) {
                return true;
            }
        }

        inStack[node] = false;

        return false;
    }
}