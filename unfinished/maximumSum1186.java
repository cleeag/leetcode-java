import javax.swing.text.MutableAttributeSet;

public class maximumSum1186 {
    public static void main(String[] args) {
//        int[] a = new int[]{1,-2,0,3};
//        int[] a = new int[]{1,-2,-2,3};
        int[] a = new int[]{-1, -1, -1, -1};
        maximumSum1186 tmp = new maximumSum1186();
        System.out.println(tmp.maximumSum(a));
    }

    public int maximumSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int rightMax = 0;
            int rightSum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
                rightMax = Math.max(rightMax, rightSum);
            }
            int leftMax = 0;
            int leftSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftSum += arr[j];
                leftMax = Math.max(leftMax, leftSum);
            }
            if (leftMax == 0 && rightMax == 0) {
                maxSum = Math.max(maxSum, arr[i]);
            } else {
                int[] combo = new int[]{leftMax, rightMax, leftMax + rightMax};
                for (int i1 : combo) {
                    maxSum = Math.max(maxSum, i1);
                    maxSum = Math.max(maxSum, i1 + arr[i]);
                }
            }
            System.out.println(leftMax + " " + rightMax + " " + maxSum);
        }
        return maxSum;
    }
}
