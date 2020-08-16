import java.util.Arrays;

public class constructFromPrePost889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;
        return grow(pre, post, 0, pre.length, 0, post.length);
    }

    public TreeNode grow(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        System.out.println(preStart + " " + preEnd + " " + postStart + " " + postEnd);
        if (preEnd <= preStart) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preEnd - preStart == 1) return root;
        int j = postEnd - 1;
        for (; j >= postStart; j--){
            if (post[j] == pre[preStart + 1]) break;
        }
        int leftLen = j - postStart + 1;
        root.left = grow(pre, post, preStart + 1, preStart + 1 + leftLen, postStart, j + 1);
        root.right = grow(pre, post, preStart + 1 + leftLen, preEnd, j + 1, postEnd - 1);
        return root;
    }
}
