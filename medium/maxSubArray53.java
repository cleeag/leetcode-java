public class maxSubArray53 {
    public static void main(String[] args) {
//        int[] n = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] n = new int[] {-1, -2};
        maxSubArray53 tmp = new maxSubArray53();
        System.out.println(tmp.maxSubArray(n));
    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int v = 0;
        int vMax = Integer.MIN_VALUE;
        int x = 0;
        int xMin = 0;
        for (int i = 0; i < nums.length; i++) {
            v += nums[i];
            vMax = Math.max(v, vMax);
            x += nums[i];
            if (x < xMin){
                v = 0;
                xMin = x;
            }
        }
        return vMax;
    }
}
