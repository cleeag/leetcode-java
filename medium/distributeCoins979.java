import java.util.Stack;

public class distributeCoins979 {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null ) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans += Math.abs(left) + Math.abs(right);
        return node.val - 1 + left + right;
    }
}
