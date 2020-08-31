import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class verticalOrder314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> pos = new LinkedList<>();
        List<List<Integer>> order = new LinkedList<>();
        if (root == null) return order;
        order.add(new LinkedList<>());
        order.get(0).add(root.val);
        q.add(root);
        pos.add(0);
        int qSize = q.size();
        while (!q.isEmpty()) {
            int shift = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = q.poll();
                int curPos = pos.poll();
                if (curNode == null) continue;
                System.out.println(curNode.val + " " + curPos);
                System.out.println(order);
                if (curNode.left != null) {
                    if (curPos == 0) {
                        order.add(0, new LinkedList<>());
                        shift++;
                    }
                    order.get(curPos + shift - 1).add(curNode.left.val);
                    q.add(curNode.left);
                    pos.add(curPos + shift - 1);
                }
                if (curNode.right != null) {
                    if (curPos + shift + 1 == order.size()) order.add(new LinkedList<>());
                    order.get(curPos + shift + 1).add(curNode.right.val);
                    q.add(curNode.right);
                    pos.add(curPos + shift + 1);
                }
            }
            qSize = q.size();
            System.out.println();
        }
        return order;
    }


    List<List<Integer>> order = new LinkedList<>();

    public List<List<Integer>> verticalOrderDFSPROBLEM(TreeNode root) {
        if (root == null) return order;
        order.add(new LinkedList<>());
        order.get(0).add(root.val);
        dfs(root, 0);
        return order;
    }

    public int dfs(TreeNode node, int pos) {
        if (node == null) return 0;
        System.out.println(node.val);
        System.out.println(order);
        if (node.left != null) {
            if (pos == 0) {
                order.add(0, new LinkedList<>());
                pos++;
            }
            order.get(pos - 1).add(node.left.val);
            pos = dfs(node.left, pos - 1) + 1;
        }
        if (node.right != null) {
            if (pos + 1 == order.size()) order.add(new LinkedList<>());
            order.get(pos + 1).add(node.right.val);
            pos = dfs(node.right, pos + 1) - 1;
        }
        return pos;
    }
}
