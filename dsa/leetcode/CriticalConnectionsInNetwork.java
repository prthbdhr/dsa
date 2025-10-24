/**
 *  #Leetcode 1192 | https://leetcode.com/problems/critical-connections-in-a-network
 */

public class CriticalConnectionsInNetwork {

    private  int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (List<Integer> conn: connections) {

            int u = conn.get(0);
            int v = conn.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        int[] time = new int[n];

        int[] low = new int[n];

        List<List<Integer>> res = new ArrayList<>();

        dfs(0, -1, vis, adj, time, low, res);

        return res;
    }

    private void dfs(
            int node, int parent, boolean[] vis,
            List<List<Integer>> adj,
            int[] time, int[] low,
            List<List<Integer>> res
    ) {

        vis[node] = true;

        time[node] = timer;

        low[node] = timer;

        timer++;

        for (Integer it: adj.get(node)) {

            if (it == parent)continue;

            if (!vis[it]) {

                dfs(it, node, vis, adj, time, low, res);

                low[node] = Math.min(low[node], low[it]);

                if (low[it] > time[node]) res.add(Arrays.asList(it, node));
            }

            else low[node] = Math.min(low[node], low[it]);
        }

        return;
    }
}