/**
 *  #Leetcode 2872 | https://leetcode.com/problems/maximum-number-of-k-divisible-components
 */

public class MaximumNumberOfKDivisibleComponents {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(0, -1, adj, values, k)[1];
    }

    private int[] dfs (int cur, int par, ArrayList<ArrayList<Integer>> adj, int[] values, int k) {
        int sum = values[cur];
        int count = 0;

        for (int neighbor : adj.get(cur)) {
            if (neighbor == par) continue;

            int[] result = dfs(neighbor, cur, adj, values, k);
            sum+= result[0];
            count += result[1];
        }

        if (sum % k == 0) {
            count++;
            sum = 0;
        }

        return new int[] {sum % k, count};
    }
}