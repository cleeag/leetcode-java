import java.util.HashMap;
import java.util.Map;

public class subarraySum560 {
    public static void main(String[] args) {
        subarraySum560 tmp = new subarraySum560();
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        tmp.subarraySum(nums, k);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int preSum = 0;
        int ans = 0;

        sumMap.put(0, 1);
        for (int num : nums) {
            preSum += num;
            int tmp = sumMap.getOrDefault(preSum - k, -1);
            if (tmp > 0) {
                ans += tmp;
            }
            if (!sumMap.containsKey(preSum))
                sumMap.put(preSum, 1);
            else
                sumMap.put(preSum, sumMap.get(preSum) + 1);

            System.out.println(sumMap);
            System.out.println(ans);
        }
        return ans;
    }
}
