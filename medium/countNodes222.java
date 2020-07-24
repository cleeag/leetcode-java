import java.util.Arrays;

public class countNodes222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }

    public int[] dfs(TreeNode node, int[] ans) {
        System.out.println(node.val);
        if (node.left == null && node.right == null) {
            ans[0]++;
            return new int[]{1, 2};
        } else if (node.right == null) {
            int[] left = dfs(node.left, ans);
            if (left[0] == 1 && left[1] == 2) {
                ans[0]++;
                return new int[]{2, 1};
            } else return new int[]{-1, -1};
        } else if (node.left == null) {
            dfs(node.right, ans);
            return new int[]{-1, -1};
        } else {
            int[] left = dfs(node.left, ans);
            int[] right = dfs(node.right, ans);
            if (left[0] == right[0]) {
                if (left[1] == 2 && (right[1] == 1 || right[1] == 2)) {
                    ans[0]++;
                    if (right[1] == 1) return new int[]{left[0] + 1, 1};
                    else return new int[]{left[0] + 1, 2};
                } else return new int[]{-1, -1};
            } else if (left[0] == right[0] + 1 && right[1] == 2) {
                ans[0]++;
                return new int[]{left[0] + 1, 1};
            } else return new int[]{-1, -1};
        }
    }
}
