public class SortedListtoBST109 {
    public TreeNode sortedListToBST(ListNode head) {
        return rec(head);
    }

    public TreeNode rec(ListNode head){
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);

        int len = 0;
        ListNode tmp = head;
        while (tmp != null){
            tmp = tmp.next;
            len += 1;
        }
        int mid = 1;
        tmp = head;
        while (mid < len / 2) {
            tmp = tmp.next;
            mid += 1;
        }

        TreeNode root = new TreeNode(tmp.next.val);
        root.right = rec(tmp.next.next);
        tmp.next = null;
        root.left = rec(head);
        return root;
    }
}
