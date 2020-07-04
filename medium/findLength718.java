import java.util.Arrays;

public class findLength718 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};
        findLength718 tmp = new findLength718();
        tmp.findLength(A, B);
    }

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int gMax = 0;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = 0;
                }
                gMax = Math.max(gMax, dp[i][j]);
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return gMax;
    }
}
