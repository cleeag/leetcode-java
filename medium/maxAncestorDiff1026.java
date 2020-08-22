public class maxAncestorDiff1026 {
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return globalMax;
    }
    int globalMax = Integer.MIN_VALUE;
    public int[] dfs(TreeNode node) {
        if (node.left == null && node.right == null) return new int[]{node.val, node.val};

        int minima = node.val, maxima = node.val;
        if (node.left != null) {
            int[] left = dfs(node.left);
            minima = Math.min(minima, left[0]);
            maxima = Math.max(maxima, left[1]);
        }
        if (node.right != null) {
            int[] right = dfs(node.right);
            minima = Math.min(minima, right[0]);
            maxima = Math.max(maxima, right[1]);
        }
        globalMax = Math.max(globalMax, Math.max(Math.abs(node.val - minima), Math.abs(node.val - maxima)));
        return new int[]{minima, maxima};
    }
}
