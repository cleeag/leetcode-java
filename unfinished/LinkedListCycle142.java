import javax.lang.model.SourceVersion;

public class LinkedListCycle142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        int firstMet = 1;
        while (slow != fast) {
            if (slow == null || fast == null) return null;
            firstMet += 1;
            slow = slow.next;
            fast = fast.next.next;
        }

        int cycleSize = 1;
        slow = slow.next;
        fast = fast.next.next;
        while (slow!=fast) {
            cycleSize += 1;
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(firstMet);
        System.out.println(cycleSize);
        ListNode ans = head;
        for (int i = 0; i < firstMet - cycleSize + 1; i++) {
            ans = ans.next;
        }

        return ans;
    }
}
