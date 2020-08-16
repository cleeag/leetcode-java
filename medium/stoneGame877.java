import java.util.Arrays;

public class stoneGame877 {
    public static void main(String[] args) {
//        int[] p = new int[]{5, 3, 4, 5, 10, 6};
        int[] p = new int[]{7,8,8,10};
        stoneGame877 tmp = new stoneGame877();
        System.out.println(tmp.stoneGame(p));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j == i) sum[i][j] = piles[i];
                else sum[i][j] = piles[j] + sum[i][j - 1];
            }
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                int j = i + k;
                if (j >= n) break;
                if (k == 0) dp[i][j] = piles[i];
                else dp[i][j] = sum[i][j] - Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
            System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println();
        }
        return dp[0][n - 1] > dp[0][n - 2] && dp[0][n - 1] > dp[1][n - 1];
    }
}
