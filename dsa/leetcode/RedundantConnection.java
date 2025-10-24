/**
 *  #Leetcode 684 | https://leetcode.com/problems/redundant-connection/
 */

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DisJointSet ds = new DisJointSet(n);

        for (int[] edge: edges) {
            if (!isUnion(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        return new int[]{};
    }

    class DisJointSet {
        private int n;
        private int[] size;
        private int[] parent;

        DisJointSet(int n) {
            this.n = n;
            size = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int uParent (int node) {
            if (!node == parent[node]) {
                parent[node] = uParent(parent[node]);
            }
           return parent[node];
        }

        public boolean isUnion(int node1, inr node2) {
            int uNode1 = uParent(node1);
            int uNode2 = uParent(node2);

            if (uNode1 == uNode2) {
                return false;
            }

            else {
                if (size[uNode1] > size[uNode2]) {
                    parent[uNode2] = uNode1;
                    size[uNode1] += size[uNode2];
                }
                else {
                    parent[uNode1] = uNode2;
                    size[uNode2] += size[uNode1];
                }

                return true;
            }
        }
    }
}