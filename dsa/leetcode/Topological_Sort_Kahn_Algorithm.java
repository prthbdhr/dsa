
// Topological Sort using Kahn's Algorithm
// This algorithm is used to find a linear ordering of vertices in a directed acyclic graph (DAG).


public class Topological_Sort_Kahn_Algorithm {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[V]; // Array to store indegree of each vertex

        for (int i = 0; i < V; i++) {

            for (int neighbor : adj.get(i)) indegree[neighbor]++; // Increment indegree for each neighbor
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            // If indegree is 0, add to queue
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] res = new int[V]; // Result array to store the topological order

        int index = 0; // Index to track the position in the result array

        while (!queue.isEmpty()) {

            int node = queue.poll(); // Get the node from the queue

            res[index++] = node; // Add the node to the result array

            // Iterate through all neighbors of the current node
            for ( int neighbor : adj.get(node)) {

                indegree[neighbor]--; // Decrease indegree of the neighbor

                if (indegree[neighbor] == 0) queue.offer(neighbor); // If indegree becomes 0, add to queue
            }
        }

        return res;
    }
}