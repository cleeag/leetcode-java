import java.util.*;

public class findDuplicateSubtrees652 {
    HashMap<String, Integer> trees = new HashMap<>();
    List<TreeNode> ans = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfsBuildStrings(root);
        return ans;
    }
    public String dfsBuildStrings(TreeNode node){
        if (node == null) return "#";
        String serial = dfsBuildStrings(node.left) + "," + dfsBuildStrings(node.right) + "," + node.val;
        trees.put(serial, trees.getOrDefault(serial, 0) + 1);
        if (trees.get(serial) == 2) ans.add(node);
        return serial;
    }
}
