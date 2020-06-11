public class FlattenBinaryTree113 {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;

        if (root.left != null) {
            TreeNode right = root.right;
            root.right = dfs(root.left);
            root.left = null;
            if (right != null) {
                TreeNode tail = root;
                while (tail.right != null) tail = tail.right;
                tail.right = dfs(right);
            }
        } else root.right = dfs(root.right);
        return root;
}
