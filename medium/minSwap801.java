import java.util.Arrays;

public class minSwap801 {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,4};
        int[] b = new int[]{1,2,3,7};
        minSwap801 tmp = new minSwap801();
        tmp.minSwap(a, b);
    }
    public int minSwap(int[] A, int[] B) {
        if (A.length <=1) return 0;
        int[][] dp = new int[2][A.length];
        dp[0][0] = 1;
        for (int i = 1; i < A.length; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[1][i] = Integer.MAX_VALUE;
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                dp[0][i] = dp[0][i - 1] + 1;
                dp[1][i] = dp[1][i - 1];
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]){
                dp[0][i] = Math.min(dp[1][i-1] + 1, dp[0][i]);
                dp[1][i] = Math.min(dp[0][i-1], dp[1][i]);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return Math.min(dp[0][A.length-1], dp[1][A.length-1]);
    }
}
