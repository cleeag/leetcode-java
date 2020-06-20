import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class nextGreaterElements503 {
    public static void main(String[] args) {
//        int[] nums = new int[] {1,2,1};
//        int[] nums = new int[] {1,2,3,2,1};
        int[] nums = new int[]{5, 4, 3, 2, 1};

        nextGreaterElements503 tmp = new nextGreaterElements503();
        tmp.nextGreaterElements(nums);

    }

    public int[] nextGreaterElements(int[] nums) {
        List<Integer> l = new LinkedList<>();
        Stack<Integer> sIdx = new Stack<>();
        int[] ans = new int[nums.length];
        int rep = 1;
        l.add(Integer.MAX_VALUE);
        for (int j = 0; j < nums.length; j++) {
            while (nums[j] > l.get(0)) {
                l.remove(0);
                ans[sIdx.pop()] = nums[j];
            }
            l.add(0, nums[j]);
            sIdx.push(j);
            if (j == nums.length - 1 && rep < 2) {
                j = -1;
                rep++;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == l.get(l.size() - 2)) ans[i] = -1;
        return ans;
    }
}
