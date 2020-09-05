public class singleNonDuplicate540 {
    public static void main(String[] args) {
//        int[] n = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] n = new int[]{1, 1, 3, 3, 4, 4, 8, 8, 9};
//        int[] n = new int[]{3, 3, 7, 7, 10, 11, 11};
//        int[] n = new int[]{3, 3, 7};
        singleNonDuplicate540 tmp = new singleNonDuplicate540();
        System.out.println(tmp.singleNonDuplicate(n));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if ((hi - mid) % 2 == 1) {
                if (nums[mid] == nums[mid + 1]) hi = mid - 1;
                else lo = mid;
            } else {
                if (nums[mid] == nums[mid + 1]) lo = mid + 1;
                else hi = mid;
            }
            System.out.println(lo + " " + mid + " " + hi);
        }
        if (lo == 0) return nums[lo];
        else if (nums[lo] == nums[lo-1]) return nums[hi];
        return nums[lo];
    }
}
