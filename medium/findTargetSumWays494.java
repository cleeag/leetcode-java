public class findTargetSumWays494 {
    public static void main(String[] args) {
        findTargetSumWays494 tmp = new findTargetSumWays494();
        int[] n = new int[]{1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(tmp.findTargetSumWays(n, S));
    }

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 1, S, nums[0]) + dfs(nums, 1, S, -nums[0]);
    }

    public int dfs(int[] nums, int index, int target, int sum) {
        if (sum == target && index == nums.length) {
            return 1;
        } else if (index == nums.length) return 0;
        return dfs(nums, index + 1, target, sum + nums[index]) +
                dfs(nums, index + 1, target, sum - nums[index]);
    }
}
