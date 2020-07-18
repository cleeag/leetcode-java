public class rob337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node.left == null && node.right == null) return node.val;
        int leftGrand = 0, rightGrand = 0;
        int left = 0, right = 0;
        if (node.left != null) {
            left = dfs(node.left);
            if (node.left.left != null) leftGrand += dfs(node.left.left);
            if (node.left.right != null) leftGrand += dfs(node.left.right);
        }
        if (node.right != null) {
            right = dfs(node.right);
            if (node.right.left != null) rightGrand += dfs(node.right.left);
            if (node.right.right != null) rightGrand += dfs(node.right.right);
        }
        int cand1 = Math.max(left + rightGrand, right + leftGrand);
        return Math.max(node.val + leftGrand + rightGrand, Math.max(left + right, cand1));
    }
}
