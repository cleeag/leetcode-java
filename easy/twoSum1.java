import java.util.HashMap;
import java.util.Map;

public class twoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hMap.containsKey(target - nums[i])) return new int[] {i, hMap.get(target - nums[i])};
            hMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
