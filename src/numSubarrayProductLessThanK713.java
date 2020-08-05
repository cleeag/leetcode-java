public class numSubarrayProductLessThanK713 {
    public static void main(String[] args) {
//        int[] n = new int[]{10, 5, 2, 6};
//        int k = 100;
//        int[] n = new int[]{1, 2, 3};
//        int k = 0;
//        int[] n = new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
//        int k = 19;
        int[] n = new int[]{1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1};
        int k = 5;
        numSubarrayProductLessThanK713 tmp = new numSubarrayProductLessThanK713();
        System.out.println(tmp.numSubarrayProductLessThanK(n, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int count = 0;
        int i = 0, j = 1;
        int cur = nums[0];
        while (j < nums.length || i < nums.length) {
            if (i == j && nums[j] >= k) {
                i++;
                j++;
            }
            while (j < nums.length && cur * nums[j] < k) cur *= nums[j++];
            count += j - i;
            System.out.println(nums[i] + " " + i + " " + j + " " + cur + " " + count);
            if (i > j) break;
            cur /= nums[i++];
        }
        return i > j ? 0 : count;
    }
}
