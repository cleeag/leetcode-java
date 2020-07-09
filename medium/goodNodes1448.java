
public class goodNodes1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode node, int maxValue){
        if (node.left == null && node.right == null){
            if (node.val >= maxValue) return 1;
            else return 0;
        }

        int returnValue = 0;
        if (node.val >= maxValue) returnValue++;
        maxValue = Math.max(maxValue, node.val);

        if (node.left != null) returnValue += dfs(node.left, maxValue);
        if (node.right != null) returnValue += dfs(node.right, maxValue);
        return returnValue;
    }
}
