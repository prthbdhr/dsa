/**
 *  #Leetcode 2415 | https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
 */

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();

        q.offer (root);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            ArrayList<TreeNode> nodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                nodes.add(cur);

                if (cur.left != null) q.offer (cur.left);

                if (cur.right != null) q.offer (cur.right);
            }

            if (level % 2 == 1) {
                int left = 0, right = nodes.size() - 1;

                while (left < right) {
                    int temp = nodes.get(right).val;
                    nodes.get(right).val = nodes.get(left).val;
                    nodes.get(left) = temp;

                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {}
    TreeNode (int val, int left, int right) {
        this.left = left;
        this.right = right;
        this.val = val
    }

    TreeNode (int val) {
        this.val = val;
    }
}