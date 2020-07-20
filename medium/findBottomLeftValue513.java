import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValue513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            Queue<TreeNode> newQ = new LinkedList<>();
            for (TreeNode curNode : q) {
                if (curNode.left!=null) newQ.offer(curNode.left);
                if (curNode.right!=null) newQ.offer(curNode.right);
            }
            if (newQ.size() == 0) break;
            else q = newQ;
        }
        return q.poll().val;
    }

}
