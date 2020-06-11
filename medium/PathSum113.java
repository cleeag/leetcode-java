import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(root, sum, 0, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs(TreeNode root, int sum, int curSum,
                    List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
        } else if (curSum + root.val == sum && root.left == null && root.right == null) {
            path.add(root.val);
            ans.add(path);
        } else {
            path.add(root.val);
            if (root.left != null)
                dfs(root.left, sum, curSum + root.val, new LinkedList<>(path), ans);
            if (root.right != null)
                dfs(root.right, sum, curSum + root.val, new LinkedList<>(path), ans);
        }
    }
}
