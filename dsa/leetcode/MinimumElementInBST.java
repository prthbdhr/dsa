package dsa;

/**
 *  https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
 */

class Node{

    int val;
    Node left;
    Node right;

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinimumElementInBST {

    int minVal( Node root) {
        if (root == null) return -1;

        if(root.left == null) return root.val;

        return minVal(root.left);
    }
}
