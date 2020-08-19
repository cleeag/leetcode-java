import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (nodes.size() > 0){
            TreeNode curNode = nodes.pop();
            if (curNode == null) continue;
            else if (curNode.left == null && curNode.right == null) ans.add(curNode.val);
            else if (nodes.size() > 0 && curNode.right == nodes.peek()) ans.add(curNode.val);
            else if (nodes.size() == 0 || curNode.right != nodes.peek()){
                nodes.push(curNode.right);
                nodes.push(curNode);
                nodes.push(curNode.left);
            }
            System.out.println(nodes);
        }
        return ans;
    }
}
