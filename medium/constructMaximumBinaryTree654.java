public class constructMaximumBinaryTree654 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree654 tmp = new constructMaximumBinaryTree654();
        tmp.constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {
        System.out.println(start + " " + end);
        if (start > end) return null;
        int maxIdx = start;
        for (int i = start; i <= end; i++)
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        TreeNode curNode = new TreeNode(nums[maxIdx]);
        curNode.left = dfs(nums, start, maxIdx-1);
        curNode.right = dfs(nums, maxIdx+1, end);
        return curNode;
    }
}
