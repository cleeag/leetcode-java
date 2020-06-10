import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree102 {
    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        q.add(root);
        int jobs = 1;
        while (!q.isEmpty()) {
            int newJobs = 0;
            List<Integer> thisLayer = new LinkedList<>();
            for (int j = 0; j < jobs; j++) {
                TreeNode tmp = q.poll();
                if (tmp != null) {
                    thisLayer.add(tmp.val);
                    q.add(tmp.left);
                    q.add(tmp.right);
                    newJobs += 2;
                }
            }
            if (thisLayer.size() > 0) res.add(thisLayer);
            jobs = newJobs;
        }
        return res;
    }
}
