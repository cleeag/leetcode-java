import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> nodes = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<TreeNode> newQ = new LinkedList<>();
            for (TreeNode treeNode : nodes) {
                if (treeNode.left!=null) newQ.add(treeNode.left);
                if (treeNode.right!=null) newQ.add(treeNode.right);
            }
            ans.add(nodes.get(nodes.size() - 1).val);
            nodes = newQ;
        }
        return ans;
    }
}
