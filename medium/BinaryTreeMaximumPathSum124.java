
public class BinaryTreeMaximumPathSum124 {

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{-1000000000};
        int tmp = dfs(root, maxSum);
        return Math.max(tmp, maxSum[0]);
    }

    public int dfs(TreeNode root, int[] maxSum) {
        if (root.left == null && root.right == null) return root.val;
        int leftVal = -1000000000;
        int rightVal = -1000000000;
        if (root.left != null)
            leftVal = dfs(root.left, maxSum);
        if (root.right != null)
            rightVal = dfs(root.right, maxSum);
        int possibleMax = Math.max(root.val,
                Math.max(
                        root.val + leftVal + rightVal,
                        Math.max(
                                Math.max(root.val + leftVal, root.val + rightVal),
                                Math.max(leftVal, rightVal))));


        if (possibleMax >maxSum[0])maxSum[0] = possibleMax;
        return Math.max(root.val,
                Math.max(root.val + leftVal, root.val + rightVal));

    }
}
