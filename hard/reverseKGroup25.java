public class reverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode cur = new ListNode(), tail = head;
        ListNode eternalHead = cur;
        cur.next = head;
        int count = 1;
        while (tail != null){
            if (count == k){
                ListNode tmpTail = tail.next;
                tail.next = null;
                ListNode tmpHead = cur.next;
                cur.next = null;
                cur.next = reverseList(tmpHead);
                tmpHead.next = tmpTail;
                cur = tmpHead;
                tail = tmpTail;
                count = 1;
            } else {
                count++;
                tail = tail.next;
            }
        }
        return eternalHead.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
