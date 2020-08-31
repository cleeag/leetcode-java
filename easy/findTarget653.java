import java.util.HashSet;
import java.util.Set;

public class findTarget653 {
    Set<Integer> seen = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (seen.contains(k - root.val)) return true;
        seen.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
