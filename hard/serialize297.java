import java.util.LinkedList;
import java.util.Queue;

public class serialize297 {
    public String serialize(TreeNode root) {
        StringBuilder ser = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int qSize = q.size();
        boolean terminate = false;
        while (!terminate) {
            terminate = true;
            System.out.println(q);
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = q.poll();
                String toAdd = cur == null ? "null" : String.valueOf(cur.val);
                ser.append(toAdd);
                ser.append(" ");
                if (cur == null) continue;
                if (cur.left != null || cur.right != null) terminate = false;
                q.add(cur.left);
                q.add(cur.right);
            }
            qSize = q.size();
        }
        System.out.println(ser.toString());
        return ser.toString();
    }


}
