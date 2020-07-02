import java.util.LinkedList;
import java.util.List;

public class longestSubarray1493 {
    public static void main(String[] args) {
//        int[] nums = new int[] {0,1,1,1,0,1,1,0,1};
        int[] nums = new int[] {1,1,0,0,1,1,1,0,1};
//        int[] nums = new int[]{0, 0, 0};
//        int[] nums = new int[]{1, 1, 1};


        longestSubarray1493 tmp = new longestSubarray1493();
        tmp.longestSubarray(nums);
    }

    public int longestSubarray(int[] nums) {
        List<Integer> seqs = new LinkedList<>();

        int oldHalf = 0;
        int newHalf = 0;
        int max = 0;
        boolean haveZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newHalf += 1;
                max = Math.max(max, newHalf);
            }
            if (nums[i] == 0) {
                haveZero = true;
                max = Math.max(max, oldHalf + newHalf);
                oldHalf = newHalf;
                newHalf = 0;
            }
            System.out.println(oldHalf + " " + newHalf + " " + max);
        }
        max = Math.max(max, oldHalf + newHalf);
        System.out.println(oldHalf + " " + newHalf + " " + max);
        return haveZero ? max : max - 1;
    }

}
