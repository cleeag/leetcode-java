import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class widthOfBinaryTree662 {
    public int widthOfBinaryTree(TreeNode root) {

    }

    public int widthOfBinaryTreeTLE(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        q.add(root);
        int newLevelSize, curLevelSize;
        while (!q.isEmpty()) {
            newLevelSize = 0;
            int front = 0;
            for (TreeNode node : q) {
                if (node == null && newLevelSize != 0) {
                    nextLevel.add(null);
                    nextLevel.add(null);
                    newLevelSize += 2;
                } else if (node != null) {
                    if (node.left != null || newLevelSize != 0) {
                        nextLevel.add(node.left);
                        newLevelSize++;
                        if (node.left != null) front = newLevelSize;
                    }
                    if (node.right != null || newLevelSize != 0) {
                        nextLevel.add(node.right);
                        newLevelSize++;
                        if (node.right != null) front = newLevelSize;
                    }
                }
            }
            q.clear();
            for (int i = 0; i < front; i++) q.add(nextLevel.poll());
            nextLevel.clear();
            maxWidth = Math.max(maxWidth, q.size());
//            System.out.println(maxWidth + " " + front);
        }
        return maxWidth;
    }
}
