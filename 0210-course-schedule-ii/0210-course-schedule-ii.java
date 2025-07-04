class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = prerequisites.length;

        for (int i = 0; i < numCourses; i++) {
            
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] prerequisite: prerequisites ) {

            int a = prerequisite[0];
            int b = prerequisite[1];

            adj.get(b).add(a);

            indegree[a]++;
        }

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) qu.add(i);
        }

        int count = 0;

        int[] res = new int[numCourses];

        while (!qu.isEmpty()) {
            int node = qu.poll();

            res[count] = node;

            count++;

            for (int it: adj.get(node)) {
                indegree[it]--;

                if (indegree[it] == 0) qu.add(it);
            }
        }

        return count == numCourses ? res : new int[0];
    }
}