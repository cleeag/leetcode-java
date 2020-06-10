import java.beans.FeatureDescriptor;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class SymmetricTree101 {
    public static void main(String[] args) {


    }

    public boolean isSymmetric(TreeNode root) {
        return rec(root, root);
    }

    public boolean rec(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null || t2 == null) return false;
        else {
            return t1.val == t2.val && rec(t1.left, t2.right) && rec(t1.right, t2.left);
        }
    }

    public boolean isSymmetric_iterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            else if (t1 == null || t2 == null) return false;
            else if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
