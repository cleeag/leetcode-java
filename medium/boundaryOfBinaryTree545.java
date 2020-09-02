import java.util.LinkedList;
import java.util.List;

public class boundaryOfBinaryTree545 {
    List<Integer> ans = new LinkedList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return ans;
        ans.add(root.val);
        if (root.left != null) leftB(root.left);
        leaves(root.left);
        leaves(root.right);
        if (root.right != null) rightB(root.right);
        return ans;
    }

    public void leftB(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        ans.add(node.val);
        if (node.left != null) leftB(node.left);
        else leftB(node.right);
    }

    public void rightB(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.right != null) rightB(node.right);
        else rightB(node.left);
        ans.add(node.val);
    }

    public void leaves(TreeNode node) {
        if (node == null) return;
        else if (node.left == null && node.right == null) {
            ans.add(node.val);
        }
        leaves(node.left);
        leaves(node.right);
    }
}
