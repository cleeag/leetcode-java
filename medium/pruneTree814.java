public class pruneTree814 {
    public TreeNode pruneTree(TreeNode root) {
        boolean res = dfs(root);
        return res ? root : null;
    }

    public boolean dfs(TreeNode node) {
        if (node == null) return true;
        if (!dfs(node.left)) node.left = null;
        if (!dfs(node.right)) node.right = null;
        return node.val == 1 || node.left != null || node.right != null;
    }
}
