import javax.lang.model.SourceVersion;
import java.util.*;

public class findSubsequences491 {
    public static void main(String[] args) {
//        int[] nums = new int[]{4, 6, 7, 7};
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};

        findSubsequences491 tmp = new findSubsequences491();
        tmp.findSubsequences(nums);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(ans, new LinkedList<>(), nums, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int idx) {
        if (path.size() > 1) ans.add(path);
        Set<Integer> hadOnes = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (hadOnes.contains(nums[i])) continue;

            List<Integer> newPath = new LinkedList<>(path);
            if (newPath.size() == 0 || nums[i] >= newPath.get(newPath.size() - 1)){
                newPath.add(nums[i]);
                dfs(ans, newPath, nums, i + 1);
            }
            hadOnes.add(nums[i]);
        }
    }
}
