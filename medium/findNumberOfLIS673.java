import java.util.Arrays;

public class findNumberOfLIS673 {
    public static void main(String[] args) {
        int[] n = new int[]{1, 3, 5, 4, 7};
//        int[] n = new int[]{1, 3, 5, 6, 4, 7};
//        int[] n = new int[]{2, 2, 2, 2, 2};
//        int[] n = new int[]{1,2,4,3,5,4,7,2,7};
//        int[] n = new int[]{3, 1, 2};

        findNumberOfLIS673 tmp = new findNumberOfLIS673();
        System.out.println(tmp.findNumberOfLIS(n));

    }

    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int lis = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                lis = Math.max(lis, dp[i]);
            }
        }
        int[] dpCount = new int[nums.length];
        int[] ans = new int[lis + 1];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) dpCount[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 == dp[i] && nums[j] < nums[i]) {
                    dpCount[i] += dpCount[j];
                }
            }
            ans[dp[i]] += dpCount[i];
        }


        System.out.println(Arrays.toString(dp));
        System.out.println(lis);
        System.out.println(Arrays.toString(dpCount));
        System.out.println(Arrays.toString(ans));
        int tmp = 0;
        if (lis == 1) {
            for (int i : dp) {
                if (i == 1) tmp++;
            }
            return tmp;
        } else return ans[lis];
    }
}
