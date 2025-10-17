package dsa;

/**
 *  https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
 */


public class CeilInBST {

    int findCeil(Node root, int key) {
        int ceil = -1;

        while (root != null) {

            if (ceil == key) return ceil;

            if (key > root.val) root = root.right;

            else {
                ceil = root.val;
                root = root.left;
            }
        }

        return  ceil;
    }

}
