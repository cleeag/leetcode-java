import java.util.Arrays;

public class minOperations1558 {
    public static void main(String[] args) {
        int[] nums = {1, 5};
//        int[] nums = {4,2,5};
//        int[] nums = {3,2,2,4};
//        int[] nums = {2, 4, 8, 16};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {1000000000};
        minOperations1558 tmp = new minOperations1558();
        tmp.minOperations(nums);
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        int maxMult = 0;
        for (int num : nums) {
            int[] tmp = reduce(num);
            ans += tmp[0];
            maxMult = Math.max(maxMult, tmp[1]);
        }
        ans += maxMult;
        System.out.println(ans);
        return ans;
    }

    public int[] reduce(int n){
        int[] count = new int[]{0, 0};
        while (n > 0){
            if (n%2==1) {
                n--;
                count[0]++;
            }
            else {
                n/=2;
                count[1]++;
            }
        }
        System.out.println(Arrays.toString(count));
        return count;
    }
}
