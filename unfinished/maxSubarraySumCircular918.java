import java.util.Arrays;

public class maxSubarraySumCircular918 {
    public static void main(String[] args) {
        int[] a = new int[]{ 1,-2,3,-2};
//        int[] a = new int[]{3, -1, 2, -1};
//        int[] a = new int[]{3, -2, 2, -3};
//        int[] a = new int[]{-2, -3, -1, 1};
//        int[] a = new int[]{-2,4,4,4,6};
//        int[] a = new int[]{3,1,3,2,6};
//        int[] a = new int[]{5, 6, 1, 4, 8, -8, 7, -5, 3};

        maxSubarraySumCircular918 tmp = new maxSubarraySumCircular918();
        tmp.maxSubarraySumCircular(a);
    }

    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        boolean allNegative = true;
        int maxNeg = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + A[i];
            if (A[i] >= 0) allNegative = false;
            else maxNeg = Math.max(maxNeg, A[i]);
        }
        if (allNegative) return maxNeg;

        int max = preSum[0];
        int minSum = A[0];
        for (int i = 1; i < n + 1; i++) {
            System.out.println(max + " " + minSum + " " + preSum[i]);
            minSum = Math.min(minSum, preSum[i] - max);
            max = Math.max(max, preSum[i]);
        }
        System.out.println(Arrays.toString(preSum));
        System.out.println(preSum[preSum.length - 1] - minSum);
        return preSum[preSum.length - 1] - minSum;
    }

    public int maxSubarraySumCircularFAIL(int[] A) {
        int[] preSum = new int[A.length * 2 - 1];
        preSum[0] = A[0];
        for (int i = 1; i < A.length; i++) preSum[i] = preSum[i - 1] + A[i];
        for (int i = 0; i < A.length - 1; i++) {
            preSum[i + A.length] = preSum[i + A.length - 1] + A[i];
        }
        System.out.println(Arrays.toString(preSum));
        int n = A.length;
        int i = 0, j = 1;
        int minIdx = j;
        int maxSum = A[0];
        while (j < preSum.length) {
            maxSum = Math.max(maxSum, preSum[j] - preSum[i]);
            if (preSum[j] <= preSum[i]) {
                i = j;
                j++;
                minIdx = j;
                continue;
            }
            if (preSum[minIdx] >= preSum[j]) minIdx = j;
            j++;

            if (j - i > A.length) i = Math.max(minIdx, i + 1);
            System.out.println(i + " " + j + " " + minIdx + " " + maxSum);
        }
        System.out.println(maxSum);
        return maxSum;
    }
}
