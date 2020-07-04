import java.util.LinkedList;
import java.util.List;

public class longestZigZag1372 {

    public int longestZigZag(TreeNode root) {
        List<Integer> gMax = new LinkedList<>();
        gMax.add(0);

        dfs(root, 0, 0, gMax);
        dfs(root, 0, 1, gMax);
        return gMax.get(0);
    }

    //dir = 0 : left, dir = 1: right
    public void dfs(TreeNode node, int count, int dir, List<Integer> gMax) {
        System.out.println(dir);
        if ((dir == 0 && node.right == null) || (dir == 1 && node.left == null)) {
            System.out.println("done");
            if (count > gMax.get(0)) {
                gMax.remove(0);
                gMax.add(count);
            }
        } else if (dir == 0) dfs(node.right, count + 1, 1, gMax);
        else if (dir == 1) dfs(node.left, count + 1, 0, gMax);

        if (dir == 0 && node.left != null) dfs(node.left, 1, 0, gMax);
        if (dir == 1 && node.right != null) dfs(node.right, 1, 1, gMax);
    }
}
