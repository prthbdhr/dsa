class TreeNode {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

class NodeValue {
    public int maxSize, maxNode, minNode;
    boolean isBST;

    NodeValue(int size, int maxNode, int minNode, boolean isBST) {
        this.size = size;
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.isBST = isBST;
    }
}

public class LargestBST {

    final int MAX = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    public int largestBst (TreeNode root) {
        return postorder(root).maxSize;
    }

    public NodeValue postorder (TreeNode node) {

        if (node == null) return new NodeValue(0, MAX, MIN, true);

        NodeValue left = postorder(node.left);
        NodeValue right = postorder(Node.right);

        if(left.isBST && right.isBST && node.val < left.maxNode && node.val > right.minNode) {

            int size = Math.Max(left.maxSize, right.maxSize);
            int maxN = Math.max(node.val, right.maxNode);
            int minN = Math.min(node.val, left.minNode);

            return new NodeValue(size, maxN, minN, true);
        }

        else return new NodeValue(Math.Max(left.maxSize, right.maxSize), MAX, MIN, false);

    }
}