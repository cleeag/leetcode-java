import java.util.LinkedList;
import java.util.List;

public class permute46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute46 tmp = new permute46();
        tmp.permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        rec(ans, nums, new LinkedList<>(), new int[nums.length]);
        System.out.println(ans);
        return ans;
    }
    public void rec(List<List<Integer>> ans, int[] nums, List<Integer> path, int[] tracker){
        if (path.size() == nums.length) ans.add(path);
        for (int i = 0; i < nums.length; i++) {
            if (tracker[i] == 0){
                tracker[i] = 1;
                List<Integer> newPath = new LinkedList<>(path);
                newPath.add(nums[i]);
                rec(ans, nums, newPath, tracker);
                tracker[i] = 0;
            }
        }
    }
}
