import java.util.Arrays;

public class minDifference1509 {
    public static void main(String[] args) {
//        int[] n = new int[]{1,5,6,14,15};
        int[] n = new int[]{82,81,95,75,20};
        minDifference1509 tmp = new minDifference1509();
        System.out.println(tmp.minDifference(n));
    }
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 5) return 0;
        int ans = Math.min(nums[nums.length-4] - nums[0], nums[nums.length-1] - nums[3]);
        ans = Math.min(ans, Math.min(nums[nums.length-2] - nums[2], nums[nums.length-3] - nums[1]));
        return ans;
    }
}
