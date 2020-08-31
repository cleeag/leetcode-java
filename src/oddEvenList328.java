import java.util.LinkedList;

public class oddEvenList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next.next;
            cur.next.next = prev.next;
            prev.next = cur.next;
            cur.next = tmp;
            prev = prev.next;
            cur = cur.next;
        }
        return head;
    }
}
