import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

public class BinaryTree103 {
    public static void main(String[] args) {
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        q.add(root);
        int zigzag = 1;
        while (!q.isEmpty()) {

            List<Integer> thisLayer = new LinkedList<>();
            int jobs = q.size();
            for (int j = 0; j < jobs; j++) {
                TreeNode tmp = q.poll();
                if (tmp != null) {
                    thisLayer.add(tmp.val);
                    q.add(tmp.left);
                    q.add(tmp.right);
                }
            }
            if (zigzag == 0){
                Collections.reverse(thisLayer);
                zigzag = 1;
            }
            else{
                zigzag = 0;
            }

            if (thisLayer.size() > 0) res.add(thisLayer);
        }
        return res;
    }
}
