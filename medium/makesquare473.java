import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class makesquare473 {
    public static void main(String[] args) {
//        int[] n = new int[]{1, 1, 2, 2, 2};
//        int[] n = new int[]{3,3,3,3,4};
        int[] n = new int[]{3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};
//        int[] n = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, 2, 1};
//        int[] n = new int[]{1569462,2402351,9513693,2220521,7730020,7930469,1040519,5767807,876240,350944,4674663,4809943,8379742,3517287,8034755};
        makesquare473 tmp = new makesquare473();
        System.out.println(tmp.makesquare(n));
    }

    public boolean makesquare(int[] nums) {
        int numSum = 0;
        for (int num : nums) numSum += num;
        int[] sums = new int[4];
        return nums.length > 0 && numSum % 4 == 0 && dfs(nums, sums, numSum / 4, 0);
    }

    boolean dfs(int[] nums, int[] sums, int target, int index) {
        if (index == nums.length) {
            for (int s : sums)
                if (target != s) return false;
            return true;
        }
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, target, index + 1)) return true;
            sums[i] -= nums[index];
        }
        return false;
    }
}
