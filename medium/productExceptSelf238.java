import java.util.Arrays;

public class productExceptSelf238 {
    public static void main(String[] args) {
        productExceptSelf238 tmp = new productExceptSelf238();

        int[] nums = new int[] {1,2,3,4};
        tmp.productExceptSelf(nums);
    }
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        forward[0] = nums[0];
        backward[nums.length-1] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            forward[i] = forward[i -1] * nums[i];
            backward[nums.length - i - 1] = backward[nums.length - i] * nums[nums.length - i - 1];
        }
        System.out.println(Arrays.toString(forward));
        System.out.println(Arrays.toString(backward));
        int[] ans = new int[nums.length];
        for (int i = 1; i < nums.length-1; i++) {
            ans[i] = forward[i-1] * backward[i+1];
        }
        ans[0] = backward[1];
        ans[nums.length-1] = forward[nums.length-2];
        return ans;
    }
}
