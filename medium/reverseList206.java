public class reverseList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseListNOTINPLACE(ListNode head) {
        if (head == null) return null;
        return rec(head)[0];
    }

    public ListNode[] rec(ListNode node) {
        System.out.println(node.val);
        if (node.next == null) {
            ListNode newHead = new ListNode(node.val);
            return new ListNode[]{newHead, newHead};
        }
        ListNode[] prev = rec(node.next);
        prev[1].next = new ListNode(node.val);
        prev[1] = prev[1].next;
        return prev;
    }
}
