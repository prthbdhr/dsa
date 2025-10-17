/**
 *  #Leetcode 515 | https://leetcode.com/problems/find-largest-value-in-each-tree-row
 */


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}


public class FindLargestValueInEachTreeRow {

    //using bfs
/**    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Deque<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while (!qu.isEmpty()) {
            int size = qu.size();
            int curMax = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                curMax = Math.max(curMax, node.val);

                if (node.left != null) qu.offer(node.left);

                if (node.right != null) qu.offer(node.right);
            }

            res.add(curMax);
        }

        return res;
    }
 **/

//                    using dfs

public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    dfs(root, 0, res);

    return res;
}

    private void dfs(TreeNode node, int dept, List<Integer> res) {
        if (node == null) return;

        if (dept == res.size()) {
            res.add(node.val);
        } else {
            res.set(dept, Math.max(res.get(dept), node.val));
        }

        dfs(node.left, dept + 1, res);
        dfs(node.right, dept + 1,res);
    }
}