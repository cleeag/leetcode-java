import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class deleteAndEarn740 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        deleteAndEarn740 tmp = new deleteAndEarn740();
        tmp.deleteAndEarn(nums);
    }

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) hMap.put(num, hMap.getOrDefault(num, 0) + 1);

        int[] uniqueNums = new int[hMap.size() + 1];
        int i = 1;
        for (Integer num : hMap.keySet()) {
            uniqueNums[i] = num;
            i++;
        }
        Arrays.sort(uniqueNums);

        i = 0;
        int[] uniqueNumsValue = new int[hMap.size() + 1];
        for (Integer num : uniqueNums) {
            uniqueNumsValue[i] = num * hMap.getOrDefault(num, 0);
            i++;
        }
        System.out.println(Arrays.toString(uniqueNums));
        System.out.println(Arrays.toString(uniqueNumsValue));

        int[] dp = new int[hMap.size() + 1];
        dp[1] = uniqueNumsValue[1];
        for (int j = 2; j < uniqueNums.length; j++) {
            if (uniqueNums[j] - uniqueNums[j-1] > 1) dp[j] = dp[j-1] + uniqueNumsValue[j];
            else{
                dp[j] = Math.max(dp[j-1], dp[j-2] + uniqueNumsValue[j]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[dp.length-1];
    }
}
