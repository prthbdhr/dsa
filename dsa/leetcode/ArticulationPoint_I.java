/**
 *  https://www.geeksforgeeks.org/problems/articulation-point-1/1
 */

public class ArticulationPoint_I {

    private int timer = 1;

    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        int[] time = new int[V];

        int[] low = new int[V];

        Set<Integer> mark = new HashSet<>();

        for (int i = 0; i < V; i++) {

            if (!vis[i]) dfs (i, -1, vis, adj, time, low, mark);
        }

        ArrayList<Integer> res = new ArrayList<>(mark);

        if (res.size() == 0) res.add(-1);

        else Collections.sort(res);

        return res;
    }

    private void dfs (int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] time, int[] low, Set<Integer> mark) {

        vis[node] = true;

        time[node] = timer;

        low[node] = timer;

        timer++;

        int child = 0;

        for (Integer it: adj.get(node)) {

            if (it == parent) continue;

            if (!vis[it]) {

                dfs (it, node, vis, adj, time, low, mark);

                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= time[node] && parent != -1) mark.add(node);

                child++;
            }

            else low[node] = Math.min(low[node], time[it]);
        }

        if (child > 1 && parent == -1) mark.add(node);

        return;
    }
}