public class findMin153 {
    public static void main(String[] args) {
//        int[] nums = new int[]{3, 4, 5, 1, 2};
        int[] nums = new int[]{4,5,6,7,0,1,2};
        findMin153 tmp = new findMin153();
        tmp.findMin(nums);
    }

    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            System.out.println(lo + " " + mid + " " + hi);
            if (nums[lo] > nums[mid]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                break;
            }
        }
        System.out.println(nums[lo]);
        return nums[lo];
    }
}
