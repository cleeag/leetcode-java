import java.util.Arrays;

public class numberOfSubarrays1248 {
    public static void main(String[] args) {
        numberOfSubarrays1248 tmp = new numberOfSubarrays1248();

//        int[] nums = new int[] {2,2,2,1,2,2,1,2,2,2};
//        int[] nums = new int[] {};
//        int[] nums = new int[] {1,1,2,1,1};
        int[] nums = new int[] {1, 1, 1, 1, 1};

        int k = 1;
        tmp.numberOfSubarrays(nums, k);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int preSum = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int res = 0;
        for (int num : nums) {
            if (num % 2 == 1){
                preSum += 1;
            }
            if (preSum - k >= 0)
                res += count[preSum - k];
            count[preSum]++;
            System.out.println(num);
            System.out.println(preSum);
            System.out.println(Arrays.toString(count));
            System.out.println(res);
            System.out.println();
        }
        return res;
    }
}
