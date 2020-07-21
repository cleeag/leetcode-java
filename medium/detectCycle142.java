import javax.lang.model.SourceVersion;

public class detectCycle142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        int firstMet = 1;
        while (slow != fast) {
            if (slow == null || fast == null) return null;
            firstMet += 1;
            slow = slow.next;
            if (fast.next != null)fast = fast.next.next;
            else return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
