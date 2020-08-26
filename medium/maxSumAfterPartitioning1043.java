import java.util.Arrays;

public class maxSumAfterPartitioning1043 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 15, 7, 9, 2, 5, 10};
        int k = 3;
//        int k = 1;
        maxSumAfterPartitioning1043 tmp = new maxSumAfterPartitioning1043();
        tmp.maxSumAfterPartitioning(a, k);
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            System.out.println(i);
            int max = dp[i] = A[i - 1];
            int localMax = A[i - 1];
            for (int j = 0; j < K; j++) {
                if (i - j - 1 >= 0) localMax = Math.max(localMax, A[i - j - 1]);
                if (i - j >= 0) max = Math.max(max, A[i - 1] * j + dp[i - j]);
                if (i - j - 1 >= 0) max = Math.max(max, localMax * (j + 1) + dp[i - j - 1]);
            }
            dp[i] = max;
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}
