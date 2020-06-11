//import java.util.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ConstructBinaryTree105 {
    public static void main(String[] args) {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rec(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode rec(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode head = new TreeNode(preorder[preStart]);

        int j = inStart;
        for (; j < inEnd; j++)
            if (inorder[j] == head.val) break;

        head.left = rec(preStart + 1, inStart, j - 1, preorder, inorder);
        head.right = rec(preStart + j - inStart + 1, j + 1, inEnd, preorder, inorder);
        return head;
    }
}
