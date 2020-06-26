public class minSubArrayLen209 {
    public static void main(String[] args) {
//        int[] nums = new int[] {2,3,1,2,4,3};
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 11;
        minSubArrayLen209 tmp = new minSubArrayLen209();
        tmp.minSubArrayLen(target, nums);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int begin = 0;
        int bestMinLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(sum + " " + begin);
            sum += nums[i];
            while (sum > s) {
                if (sum - nums[begin] < s) break;
                sum -= nums[begin];
                begin++;
                System.out.println(sum + " " + begin);
            }
            if (sum >= s) bestMinLen = Math.min(bestMinLen, i - begin + 1);
        }
        System.out.println(bestMinLen);
        return bestMinLen == Integer.MAX_VALUE? 0: bestMinLen;
    }
}
