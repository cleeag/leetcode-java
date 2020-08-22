public class smallestFromLeaf988 {

    public static void main(String[] args) {
        String a = "";
        String b = "a";
        System.out.println(a.compareTo(b));
    }

    String smallest = "";

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return smallest;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.insert(0, (char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            String candidate = sb.toString();
            if (smallest.equals("")) smallest = candidate;
            else smallest = smallest.compareTo(candidate) > 0 ? candidate : smallest;
        }
        if (node.left != null) dfs(node.left, sb);
        if (node.right != null) dfs(node.right, sb);
        sb.deleteCharAt(0);
    }
}
