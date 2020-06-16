public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode tmp1 = head;
        ListNode tmp2 = head.next;
        while (tmp2!=null && tmp2.next != null) {
            ListNode endPrev = tmp1;
            ListNode end = tmp2;
            while (end.next != null) {
                end = end.next;
                endPrev = endPrev.next;
            }
            endPrev.next = null;
            tmp1.next = end;
            end.next = tmp2;
            tmp1 = tmp2;
            tmp2 = tmp2.next;
        }
    }
}
