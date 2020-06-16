import java.util.LinkedList;
import java.util.List;

public class SumRoottoLeafNumbers129 {
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans, "");
        int res = 0;
        for (Integer a : ans) res += a;
        return res;
    }

    public void dfs(TreeNode node, List<Integer> ans, String path){
        path += String.valueOf(node.val);
        if (node.left == null && node.right == null)
            ans.add(Integer.parseInt(path));
        if (node.left != null) dfs(node.left, ans, path);
        if (node.right != null) dfs(node.right, ans, path);
    }
}
