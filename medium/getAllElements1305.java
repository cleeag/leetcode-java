import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class getAllElements1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new LinkedList<>();
        dfs(root1, ans);
        dfs(root2, ans);
        ans.sort(Integer::compareTo);
        return ans;
    }

    public void  dfs(TreeNode node, List<Integer> ans) {
        if (node == null) return ;
        dfs(node.left, ans);
        ans.add(node.val);
        dfs(node.right, ans);
    }
}
