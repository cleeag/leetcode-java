import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int qSize = q.size();
            while (qSize > 0){
                TreeNode cur = q.poll();
                if (cur == null){
                    while (!q.isEmpty()){
                        if (q.poll() != null) return false;
                    }
                    return true;
                }
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return true;
    }
}
