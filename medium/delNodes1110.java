import java.util.*;

public class delNodes1110 {
    List<TreeNode> ans = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for (int num : to_delete) toDelete.add(num);
        if (!dfsDelete(root, toDelete)) ans.add(root);
        return ans;
    }

    public boolean dfsDelete(TreeNode node, Set<Integer> toDelete) {
        if (node == null) return false;
        System.out.println(node.val);
        if (dfsDelete(node.left, toDelete)) {
            node.left = null;
        } else if (toDelete.contains(node.val) && node.left != null) {
            ans.add(node.left);
        }

        if (dfsDelete(node.right, toDelete)) {
            node.right = null;
        } else if (toDelete.contains(node.val) && node.right != null) {
            ans.add(node.right);
        }
        return toDelete.contains(node.val);
    }
}
