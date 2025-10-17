package dsa;

public class FloorInBST {

    public static int floor(Node root, int x) {
        // Code here

        int floor = -1;

        while (root != null) {

            if (floor == x) return floor;

            if (x < root.val) root = root.left;

            else {

                floor = root.val;

                root = root.right;
            }

        }

        return floor;
    }
}
