public class singleNonDuplicate540 {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((hi - lo) % 2 == 0) {
                if ((nums[hi] == nums[hi - 1] && nums[mid] == nums[mid - 1])
                        || (hi < nums.length - 1 && nums[hi] == nums[hi + 1] && nums[mid] == nums[mid + 1])) hi = mid;
                else lo = mid;
            } else {

            }

            if (nums[mid] == nums[mid + 1]) {

            }

        }

    }
}
