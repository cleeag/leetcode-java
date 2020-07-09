import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class pseudoPalindromicPaths1457 {
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> valSet = new HashSet<>();
        return dfs(root, valSet);
    }

    public int dfs(TreeNode node, Set<Integer> valSet){
        System.out.println(valSet);
        if (node.left == null && node.right == null){
            if (valSet.size() == 0 || (valSet.size() <= 2 && valSet.contains(node.val))) return 1;
            else return 0;
        }

        if (valSet.contains(node.val)) valSet.remove(node.val);
        else valSet.add(node.val);

        int returnVal = 0;
        if (node.left != null) returnVal += dfs(node.left, new HashSet<>(valSet));
        if (node.right != null) returnVal += dfs(node.right, new HashSet<>(valSet));
        System.out.println(returnVal);
        return returnVal;
    }
}
