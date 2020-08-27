import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> p = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode lHead : lists) {
            if (lHead != null) p.offer(lHead);
        }
        if (p.size() == 0) return null;
        ListNode head = p.poll();
        if (head.next != null) p.offer(head.next);
        ListNode cur = head;
        while (p.size() > 0){
            cur.next = p.poll();
            cur = cur.next;
            if (cur.next != null) p.offer(cur.next);
        }
        return head;
    }
}
