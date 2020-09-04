public class missingElement1060 {
    public static void main(String[] args) {
//        int[] n = new int[]{4, 7, 9, 10};
        int[] n = new int[]{1, 2, 4};
        int k = 3;
        missingElement1060 tmp = new missingElement1060();
        tmp.missingElement(n, k);
    }

    public int missingElement(int[] nums, int k) {
        int lo = 0, hi = nums.length;
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[0] + mid - 1 + k) hi = mid;
            else lo = mid;
            System.out.println(lo + " " + mid + " " + hi);
        }
        int ans = nums[lo] + k - (nums[lo] - nums[0] - lo);
        System.out.println(lo);
        System.out.println(ans);
        return ans;
    }
}
