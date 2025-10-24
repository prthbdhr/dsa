class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode oddHead = new ListNode(-1), oddTail = oddHead;

        ListNode evenHead = new ListNode(-1), evenTail = evenHead;

        ListNode curr = head;

        int index = 1;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = null;

            if (index % 2 != 0) {

                oddTail.next = curr;

                oddTail = curr;
            } 
            
            else {

                evenTail.next = curr;

                evenTail = curr;
            }

            curr = next;

            index++;
        }

        oddTail.next = evenHead.next;
        
        return oddHead.next;
    }
}