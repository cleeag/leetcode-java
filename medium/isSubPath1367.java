public class isSubPath1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean dfs(ListNode cur, TreeNode node) {
        if (cur == null) return true;
        if (node == null) return false;
        return node.val == cur.val && (dfs(cur.next, node.left) || dfs(cur.next, node.right));
    }
}
