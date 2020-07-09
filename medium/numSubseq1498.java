import java.util.Arrays;

public class numSubseq1498 {
    public static void main(String[] args) {
//        int[] n = new int[]{3, 5, 6, 7};
//        int target = 9;
//        int[] n = new int[]{3, 3, 6, 8};
//        int target = 10;

//        int[] n = new int[]{2,3,3,4,6,7};
//        int target = 12;

        int[] n = new int[]{5, 2, 4, 1, 7, 6, 8};
        int target = 16;

        numSubseq1498 tmp = new numSubseq1498();
        System.out.println(tmp.numSubseq(n, target));

    }

    public int numSubseq(int[] nums, int target) {
        int mod = (int) 1e9 + 7;
        Arrays.sort(nums);
        int ans = 0;
        int[] powArray = new int[nums.length];
        powArray[0] = 1;
        for (int i = 1; i < powArray.length; i++) {
            powArray[i] = powArray[i - 1] * 2 % mod;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] + nums[high] > target) high--;
            else {
                int pow = powArray[high - low];
                ans = (ans + pow)  % mod;
                low++;
            }
        }
        return ans;
    }
}
