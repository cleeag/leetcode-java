import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class allPossibleFBT894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new LinkedList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
        } else {
            for (int i = 1; i < N - 1; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - 1 - i);
                for (TreeNode leftTree : left) {
                    for (TreeNode rightTree : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftTree;
                        root.right = rightTree;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
}
