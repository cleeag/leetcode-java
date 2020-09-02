import java.util.Arrays;

public class getMaxLen1567 {
    public static void main(String[] args) {
//        int[] m = new int[]{0, 1, -2, -3, -4};
//        int[] m = new int[]{-1,-2,-3,0,1};
        int[] m = new int[]{1,2,3,5,-6,4,0,10};
        getMaxLen1567 tmp = new getMaxLen1567();
        tmp.getMaxLen(m);
    }

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] preProd = new int[n];
        if (nums[0] == 0) preProd[0] = 0;
        else preProd[0] = nums[0] > 0 ? 1 : -1;
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) preProd[i] = 0;
            else if (preProd[i - 1] == 0) preProd[i] = nums[i] > 0 ? 1 : -1;
            else {
                preProd[i] = nums[i] > 0 == preProd[i - 1] > 0 ? 1 : -1;
            }
        }
        System.out.println(Arrays.toString(preProd));
        int earliestPos = -1, earliestNeg = -1;
        int negCount = 0;
        for (int i = 0; i < n; i++) {
            if (preProd[i] == 0) {
                earliestNeg = -1;
                earliestPos = i;
//                negCount = 0;
            }
//            if (preProd[i] < 0) {
//                if (negCount == 1) negCount = 0;
//                else negCount = 1;
//            }
//            if (earliestPos == -1 && preProd[i] > 0) earliestPos = i;
            if (earliestNeg == -1 && preProd[i] < 0) earliestNeg = i;
            if (preProd[i] > 0) maxLen = Math.max(maxLen, i - earliestPos);
            if (preProd[i] < 0 && earliestNeg != -1) maxLen = Math.max(maxLen, i - earliestNeg);
//            if (nums[i] < 0 && negCount == 0) maxLen = Math.max(maxLen, i - earliestPos);
            System.out.println(i + " " + nums[i] + " " + earliestPos + " " + earliestNeg + " " + maxLen + " " + negCount);
        }
        return maxLen;
    }
}
