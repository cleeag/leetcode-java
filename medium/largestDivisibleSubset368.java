import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class largestDivisibleSubset368 {
    public static void main(String[] args) {
//        int[] n = new int[]{1,2,3,4,6,8};
//        int[] n = new int[]{546, 669};
        int[] n = new int[]{2,3,4,9,8};
        largestDivisibleSubset368 tmp = new largestDivisibleSubset368();
        tmp.largestDivisibleSubset(n);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 1) {
            List<Integer> tmp = new LinkedList<>();
            tmp.add(nums[0]);
            return tmp;
        }
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        int globalMax = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    globalMax = Math.max(globalMax, dp[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        List<Integer> ans = new LinkedList<>();
        int cur = globalMax;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (ans.size() == 0 && dp[i] == globalMax) {
                ans.add(nums[i]);
                cur--;
                if (globalMax == 1) break;
            } else if (ans.size() > 0 && ans.get(ans.size() - 1) % nums[i] == 0 && dp[i] == cur) {
                ans.add(nums[i]);
                cur--;
            }
            System.out.println(ans);
        }
        return ans;
    }
}
