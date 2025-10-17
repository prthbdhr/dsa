package dsa;

/**
 *  LeetCode 450 | leetcode.com/problems/delete-node-in-a-bst/description/
 */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete is found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Find the inorder successor (smallest value in the right subtree)
            TreeNode successor = findMin(root.right);

            // Replace the node's value with the successor's value
            root.val = successor.val;

            // Delete the successor node in the right subtree
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
