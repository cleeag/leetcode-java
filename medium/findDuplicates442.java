import java.util.LinkedList;
import java.util.List;

public class findDuplicates442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int num : nums) {
            int tmp = Math.abs(num) - 1;
            if (nums[tmp] < 0) ans.add(tmp + 1);
            else nums[tmp] = -nums[tmp];
        }
        return ans;
    }
}
