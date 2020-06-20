import javax.lang.model.SourceVersion;
import java.util.Arrays;

public class minFallingPathSum931 {
    public static void main(String[] args) {
        minFallingPathSum931 tmp = new minFallingPathSum931();
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int ans = tmp.minFallingPathSum(A);
        System.out.println(ans);
    }

    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) return 0;
        int[][] dp = new int[A.length][A[0].length];
        System.arraycopy(A[A.length - 1], 0, dp[dp.length - 1], 0, A[0].length);

        for (int i = A.length-1; i > 0 ; i--) {
            for (int j = 0; j < A[0].length; j++) {
                int minSum = Integer.MAX_VALUE;
                for (int k = -1; k < 2; k++) {
                    if (j + k >= 0 && j + k < A[0].length) minSum = Math.min(dp[i][j + k], minSum);
                }
                dp[i-1][j] = minSum + A[i-1][j];
            }
            System.out.println(Arrays.deepToString(dp));
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) minSum = Math.min(minSum, dp[0][i]);
        return minSum;
    }


    public int minFallingPathSumFailed(int[][] A) {
        if (A.length == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < A[0].length; j++) {
            for (int k = -1; k < 2; k++) {
                if (j + k >= 0 && j + k < A[0].length) {
                    ans = Math.min(ans, A[0][j] + rec(A, 1, j + k));
                }
            }
        }
        return ans;
    }

    public int rec(int[][] a, int i, int j) {
        System.out.println(i + " " + j);
        if (i == a.length) return 0;
        int minSum = Integer.MAX_VALUE;
        for (int k = -1; k < 2; k++) {
            if (j + k >= 0 && j + k < a[0].length)
                minSum = Math.min(minSum, rec(a, i + 1, j + k));
        }
        return a[i][j] + minSum;
    }
}
