import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class buildTree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) hMap.put(inorder[i], i);
        int inS = 0, inE = inorder.length, posS = 0, posE = inorder.length;
        return build(hMap, inorder, postorder, inS, inE, posS, posE);
    }

    public TreeNode build(Map<Integer, Integer> hMap, int[] in, int[] post, int inS, int inE, int posS, int posE) {
        if (inE - inS == 0) return null;
        TreeNode head = new TreeNode(post[posE - 1]);
        if (inE - inS == 1) return head;
        int i = hMap.get(post[posE - 1]);
        System.out.println(inS + " " + inE + " " + posS + " " + posE);
        head.left = build(hMap, in, post, inS, i, posS, posS + i - inS);
        head.right = build(hMap, in, post, i + 1, inE, posS + i - inS, posS + i - inS + inE - (i + 1));
        return head;
    }
}
