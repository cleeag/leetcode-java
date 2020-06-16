public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        return rec(nums, 0, nums.length);
    }

    public int rec(int[] nums, int p, int q) {
        if (p == q) return p;
        int m = (p + q) / 2;
        if (nums[m] < nums[m + 1])
            return rec(nums, m+1, q);
        else
            return rec(nums, p, m);
    }
}
