import java.util.Arrays;

public class canPartitionKSubsets698 {
    public static void main(String[] args) {
//        int[] n = new int[]{4, 3, 2, 3, 5, 2, 1};
//        int k = 4;
        int[] n = new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6};
        int k = 3;
        canPartitionKSubsets698 tmp = new canPartitionKSubsets698();
        System.out.println(tmp.canPartitionKSubsets(n, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (k <= 0 || sum % k != 0) return false;
        int target = sum / k;
        int[] tracker = new int[nums.length];
        return dfs(nums, tracker, target, 0, 0, k);
    }

    public boolean dfs(int[] nums, int[] tracker, int target, int idx, int curSum, int k) {
        if (k == 1) return true;
        if (curSum > target) return false;
        else if (curSum == target) return dfs(nums, tracker, target, 0, 0, k - 1);

        for (int i = idx; i < nums.length; i++) {
            if (tracker[i] == 0) {
                tracker[i] = 1;
                if (dfs(nums, tracker, target, i + 1, curSum + nums[i], k)) return true;
                tracker[i] = 0;
            }
        }
        return false;
    }
}
