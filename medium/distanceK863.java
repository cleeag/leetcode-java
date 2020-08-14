import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class distanceK863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<TreeNode> path = new LinkedList<>();
        path.add(root);
        find(root, path, target.val);

        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i).val);
            if (path.size() - i - 1 > K) continue;
            else if (path.size() - i - 1 == K) {
                ans.add(path.get(i).val);
                continue;
            }

            TreeNode curNode = path.get(i);
            if (i < path.size() - 1) {
                int targetDis = K - (path.size() - i - 1) - 1;
                if (path.get(i + 1) == curNode.left) {
                    dfs(curNode.right, 0, targetDis, ans);
                } else {
                    dfs(curNode.left, 0, targetDis, ans);
                }
            } else{
                dfs(curNode, 0, K, ans);
            }
        }
        return ans;
    }

    public boolean find(TreeNode node, List<TreeNode> path, int target) {
        if (node == null) return false;
        else if (node.val == target) return true;

        path.add(node.left);
        if (find(node.left, path, target)) return true;
        path.remove(path.size() - 1);

        path.add(node.right);
        if (find(node.right, path, target)) return true;
        path.remove(path.size() - 1);

        return false;
    }

    public void dfs(TreeNode node, int distance, int target, List<Integer> ans) {
        if (node == null) return;
        else if (distance == target) {
            ans.add(node.val);
            return;
        }
        dfs(node.left, distance + 1, target, ans);
        dfs(node.right, distance + 1, target, ans);
    }
}
