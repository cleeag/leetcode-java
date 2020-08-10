import java.util.Stack;

public class distributeCoins979 {
    public int distributeCoins(TreeNode root) {
        Stack<Integer> surplusNodes = new Stack<>();
        Stack<Integer> moves = new Stack<>();
    }

    public void dfs(TreeNode node, Stack<Integer> surplusNodes, Stack<Integer> moves) {
        if (node == null) return;

        if (node.val > 1) {
            surplusNodes.push(node.val);
            moves.push()
        }

        if (node.left != null) leftSurplus = dfs(node.left);
        if (node.right != null) rightSurplus = dfs(node.right);

    }
}
