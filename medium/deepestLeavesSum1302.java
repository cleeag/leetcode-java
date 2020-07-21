import java.util.LinkedList;
import java.util.Queue;

public class deepestLeavesSum1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int qSize = q.size();
        while (!q.isEmpty()) {
            ans = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = q.poll();
                System.out.println(curNode.val);
                if (curNode.left == null && curNode.right == null) ans += curNode.val;
                if (curNode.left != null) q.add(curNode.left);
                if (curNode.right != null) q.add(curNode.right);
            }
            System.out.println();
            qSize = q.size();
        }
        return ans;
    }
}
