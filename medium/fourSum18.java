import java.util.*;

public class fourSum18 {
    public static void main(String[] args) {
//        int[] n = new int[]{-495, -477, -464, -424, -411, -409, -363, -337, -328, -328, -325, -320, -310, -285, -278, -235, -208, -151, -149, -147, -144, -132, -115, -107, -101, -98, -83, -58, -58, -56, -51, -46, -45, -7, 0, 4, 4, 21, 51, 52, 57, 60, 104, 109, 124, 141, 158, 205, 206, 241, 278, 278, 291, 314, 379, 416, 437, 447, 452, 496};
//        int t = -1371;
//
//        int[] n = new int[]{-499, -486, -479, -462, -456, -430, -415, -413, -399, -381, -353, -349, -342, -337, -336, -331, -330, -322, -315, -280, -271, -265, -249, -231, -226, -219, -216, -208, -206, -204, -188, -159, -144, -139, -123, -115, -99, -89, -80, -74, -61, -22, -22, -8, -5, 4, 43, 65, 82, 86, 95, 101, 103, 123, 149, 152, 162, 165, 168, 183, 204, 209, 209, 220, 235, 243, 243, 244, 248, 253, 260, 273, 281, 284, 288, 290, 346, 378, 382, 384, 407, 411, 423, 432, 433, 445, 470, 476, 497};
//        int t = 3032;
//        int[] n = new int[] {1, 0, -1, 0, -2, 2};
//        int t = 0;
//        int[] n = new int[] {-1,0,1,2,-1,-4};
//        int t = -1;
//        int[] n = new int[] {0, 0, 0, 0};
//        int t = 0;
        int[] n = new int[] {3,1,4,2,5,-4,2,4,-5};
        int t = -12;
        fourSum18 tmp = new fourSum18();
        tmp.fourSum(n, t);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) continue;
                int twoSum = target - (nums[i] + nums[j]);
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    System.out.println(i + " " + j + " " + low + " " + high);
                    if (low - j > 1 && nums[low] == nums[low - 1]) low++;
                    else if (high < nums.length - 1 && nums[high] == nums[high + 1]) high--;
                    else if (nums[low] + nums[high] == twoSum){
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(nums[low]);
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[high]);
                        ans.add(tmp);
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] < twoSum) low++;
                    else high--;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    public void dfsTLE(List<List<Integer>> ans, int[] nums, int target, int curSum, List<Integer> path, int index) {
        System.out.println(path);
        if (curSum == target && path.size() == 4) ans.add(path);
        else if (index > nums.length || path.size() >= 4) return;

        Set<Integer> had = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
//            if (had.contains(nums[i]) || (path.size() > 0 && curSum > target)) continue;
            if (had.contains(nums[i])) continue;
            List<Integer> newPath = new LinkedList<>(path);
            newPath.add(nums[i]);
            dfsTLE(ans, nums, target, curSum + nums[i], newPath, i + 1);
            had.add(nums[i]);
        }
    }
}
