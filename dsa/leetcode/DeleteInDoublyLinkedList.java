/**
 * https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list
 */

public class DeleteInDoublyLinkedList {
    public Node deleteNode(Node head, int x) {
        if (head == null || x <= 0) {
            return head;
        }

        if (x == 1) {
            Node newHead = head.next;

            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }

        Node cur = head;
        int count = 1;

        while (cur != null || count < x) {
            cur = cur.next;
            count++;
        }

        if (cur == null) {
            return head;
        }

        if (cur.prev != null) {
            cur.prev.next = cur.next;
        }

        if (cur.next != null) {
            cur.next.prev =  cur.prev;
        }

        return head;
    }
}