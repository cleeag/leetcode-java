import java.util.Arrays;

public class lengthOfLIS300 {
    public static void main(String[] args) {
        int[] a = new int[] {10,9,2,5,3,7,101,18};
        lengthOfLIS300 tmp = new lengthOfLIS300();
        tmp.lengthOfLIS(a);
    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) if (nums[j] < nums[i] && dp[j] >= dp[i]) dp[i] = dp[j] + 1;
            if (dp[i] > ans) ans = dp[i];
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
}
