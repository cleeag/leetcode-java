import java.util.LinkedList;
import java.util.Queue;

public class maxLevelSum1161 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int qSize = q.size();
        int maxSum = Integer.MIN_VALUE;
        int level = 1, maxLevel = 1;
        while (!q.isEmpty()){
            int levelSum = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = q.poll();
                levelSum += curNode.val;
                if (curNode.left!=null) q.add(curNode.left);
                if (curNode.right!=null) q.add(curNode.right);
            }
            System.out.println(level + " " + maxSum + " " + maxLevel + " "+ level);
            if (levelSum > maxSum) {
                maxLevel = level;
                maxSum = levelSum;
            }
            level++;
            qSize = q.size();
        }
        return maxLevel;
    }
}
