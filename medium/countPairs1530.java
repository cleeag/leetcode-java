import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class countPairs1530 {
    public int countPairs(TreeNode root, int distance) {
        int[] ans = new int[1];
        dfs(root, distance, ans);
        return ans[0];
    }

    public List<Integer> dfs(TreeNode node, int distance, int[] ans) {
        List<Integer> totList = new LinkedList<>();
        if (node.left == null && node.right == null)
            return Arrays.asList(1);
        else if (node.left != null && node.right != null) {
            List<Integer> leftList = dfs(node.left, distance, ans);
            List<Integer> rightList = dfs(node.right, distance, ans);
            System.out.println(leftList);
            System.out.println(rightList);
            System.out.println(ans[0]);
            for (Integer l : leftList) {
                for (Integer r : rightList) {
                    if (l + r <= distance) ans[0]++;
                }
            }
            for (Integer n : leftList) totList.add(n + 1);
            for (Integer n : rightList) totList.add(n + 1);
        } else if (node.left != null) {
            List<Integer> leftList = dfs(node.left, distance, ans);
            for (Integer l : leftList) totList.add(l + 1);
        } else {
            List<Integer> rightList = dfs(node.right, distance, ans);
            for (Integer r : rightList) totList.add(r + 1);
        }
        return totList;
    }
}
