class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int v = graph.length;

        int[] indegree = new int[v];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < v; i++) {

            for (int it: graph[i]) {
                adj.get(it).add(i);

                indegree[i]++;
            }
        }

        Queue<Integer> qu  = new LinkedList<>();

        for (int i = 0; i < v; i++) {

            if (indegree[i] == 0) qu.add(i);
        }

        List<Integer> res = new ArrayList<>();

        while (!qu.isEmpty()) {

            int node = qu.poll();

            res.add(node);

            for (int it: adj.get(node)) {

                indegree[it]--;

                if (indegree[it] == 0) qu.add(it);
            }
        }

        Collections.sort(res);
        
        return res;
    }
}