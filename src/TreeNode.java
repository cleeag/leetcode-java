import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Arrays;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(List<Integer> arr) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode head =new TreeNode(arr.get(0));
        arr.remove(0);
        q.add(head);
        while (!q.isEmpty() && !arr.isEmpty()){
            TreeNode cur = q.poll();
            if (cur == null) continue;
            int left_val = arr.get(0);
            if (left_val != 0){
                TreeNode left = new TreeNode(arr.get(0));
                arr.remove(0);
                cur.left = left;
                q.add(left);
            }

            if (arr.size() > 0){
                TreeNode right =new TreeNode(arr.get(0));
                arr.remove(0);
                cur.right = right;
                q.add(right);
            }
        }
        this.val = head.val;
        this.left = head.left;
        this.right = head.right;
    }
    public void print(){
        System.out.println(val);
        if (left!=null) left.print();
        if (right!=null) right.print();
    }
    public static void main(String[] args){
        int[] array = {1,2,2,3,4,4,3};
//        int[] array2 = {1,2,2,null,3,3};
//        List<Integer> test = Arrays.asList(new int[]{1, 2, 2, 3, 4, 4, 3});
        List<Integer> test = new ArrayList(Arrays.asList(1,2,2,null,3,3));
        TreeNode a = new TreeNode(test);
        a.print();
    }
}

