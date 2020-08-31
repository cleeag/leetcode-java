import java.util.LinkedList;
import java.util.Queue;

public class deserialize297 {
    public TreeNode deserialize(String data) {
        String[] splited = data.split("\\s+");
        if (splited[0].equals("null")) return null;
        TreeNode head = new TreeNode(Integer.parseInt(splited[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(head);
        int qSize = q.size();
        int idx = 1;
        while (idx < splited.length) {
//            System.out.println(idx);
//            System.out.println(q);
            int childCount = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = q.poll();
                if (cur == null) continue;
                int leftIdx = idx + 2 * childCount;
                int rightIdx = idx + 2 * childCount + 1;
//                System.out.println(leftIdx + " " + rightIdx);
                cur.left = splited[leftIdx].equals("null") ? null : new TreeNode(Integer.parseInt(splited[leftIdx]));
                cur.right = splited[rightIdx].equals("null") ? null : new TreeNode(Integer.parseInt(splited[rightIdx]));
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                childCount++;
            }
            idx += qSize * 2;
            qSize = q.size();
        }
        return head;
    }
}
