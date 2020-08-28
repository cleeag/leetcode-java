public class sortList148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;

        ListNode preMid = head, tail = head.next;
        while (tail != null) {
            tail = tail.next;
            if (tail == null) break;
            preMid = preMid.next;
            tail = tail.next;
        }
        ListNode mid = preMid.next;
        preMid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode mergedHead = new ListNode();
        ListNode merged = mergedHead;
        while (left != null || right != null) {
            if (left == null){
                merged.next = right;
                right = right.next;
            }
            else if (right == null) {
                merged.next = left;
                left = left.next;
            }
            else if (left.val < right.val) {
                merged.next = left;
                left = left.next;
            }
            else {
                merged.next = right;
                right = right.next;
            }
            merged = merged.next;
            merged.next = null;
        }
        return mergedHead.next;
    }
}
