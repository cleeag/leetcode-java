import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class largestValues515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        q.add(root);
        int max;
        while (!q.isEmpty()){
            max = Integer.MIN_VALUE;
            Queue<TreeNode> newQ = new LinkedList<>();
            for (TreeNode node : q) {
                max = Math.max(max, node.val);
                if (node.left != null) newQ.add(node.left);
                if (node.right != null) newQ.add(node.right);
            }
            ans.add(max);
            q = newQ;
        }
        return ans;
    }
}
