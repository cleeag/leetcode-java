import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class generateTrees95 {
    public static void main(String[] args) {
        generateTrees95 tmp = new generateTrees95();
        tmp.generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int left, int right) {
        System.out.println(left + " " + right);
        if (right < left) {
            List<TreeNode> tmp =  new LinkedList<>();
            tmp.add(null);
            return tmp;
        }
        if (left == right){
            List<TreeNode> tmp =  new LinkedList<>();
            tmp.add(new TreeNode(right));
            return tmp;
        }
        List<TreeNode> curTrees = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            System.out.println(i);
            List<TreeNode> leftTrees = dfs(left, i - 1);
            List<TreeNode> rightTrees = dfs(i + 1, right);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = leftTrees.get(j);
                    tmp.right = rightTrees.get(k);
                    curTrees.add(tmp);
                }
            }
        }
        System.out.println();
        return curTrees;
    }

    public TreeNode addNode(TreeNode head, int addition) {
        System.out.println(addition);
        TreeNode cur = head;
        while (true) {
            if (cur.val > addition) {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(addition);
                    break;
                }
            } else {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(addition);
                    break;
                }
            }
        }
        return head;
    }
}
