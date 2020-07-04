import java.util.Arrays;

public class largestSumOfAverages813 {
    public static void main(String[] args) {
        int[] a = new int[]{9, 1, 2, 3, 9};
        int k = 3;
//        int[] a = new int[]{4,1,7,5,6,2,3};
//        int k = 4;

        largestSumOfAverages813 tmp = new largestSumOfAverages813();
        tmp.largestSumOfAverages(a, k);
    }

    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[K][n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            dp[0][i] = sum / (i + 1);
        }

        for (int i = 1; i < K; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < j; k++) {
                    double lSum = 0;
                    for (int l = k + 1; l <= j; l++) lSum += A[l];
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + lSum / (j - k));
                }
            }
        }
        return dp[K-1][n-1];
    }
}
