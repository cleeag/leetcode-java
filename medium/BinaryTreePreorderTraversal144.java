import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> rights = new Stack<TreeNode>();
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        TreeNode node = root;
        while (true) {
            ans.add(node.val);
            if (node.right != null) rights.push(node.right);

            if (node.left != null) node = node.left;
            else if (!rights.isEmpty()) node = rights.pop();
            else break;
        }
        return ans;
    }
}
