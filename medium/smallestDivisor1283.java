public class smallestDivisor1283 {
    public static void main(String[] args) {
//        int[] n = new int[]{1,2,5,9};
//        int t = 6;
//
//        int[] n = new int[]{2,3,5,7,11};
//        int t = 11;
        int[] n = new int[]{1,2,3};
        int t = 6;
        smallestDivisor1283 tmp = new smallestDivisor1283();
        System.out.println(tmp.smallestDivisor(n, t));
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int hi = 0, lo = 0;
        for (int num : nums) hi = Math.max(hi, num);
        while (lo < hi){
            int mid = (lo + hi) / 2;
            System.out.println(lo + " " + hi + " " + mid);
            if (mid == 0) return 1;
            if (can(nums, mid, threshold)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public boolean can(int[] nums, int div, int thresh){
        int sum = 0;
        for (int num : nums) {
            if (num % div == 0) sum+=num / div;
            else sum += num / div + 1;
        }
        System.out.println(div + " " + (sum <= thresh));
        return sum <= thresh;
    }
}
