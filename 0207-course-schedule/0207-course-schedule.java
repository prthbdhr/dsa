class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int n = prerequisites.length;

        int[] indegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = constuctAdj(numCourses, prerequisites);

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) for (int it: adj.get(i)) indegree[it] ++;

        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) qu.add(i);

        int vis = 0;

        while (!qu.isEmpty()) {

            int node = qu.poll();

            vis++;

            for (int it: adj.get(node)) {

                indegree[it]--;

                if (indegree[it] == 0) qu.add(it);
            }
        }

        return vis == numCourses;
    }

    private ArrayList<ArrayList<Integer>> constuctAdj(int n, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge: prerequisites) adj.get(edge[1]).add(edge[0]);

        return adj;
    }
}