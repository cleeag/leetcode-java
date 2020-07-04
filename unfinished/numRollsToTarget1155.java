import java.util.Arrays;

public class numRollsToTarget1155 {
    public static void main(String[] args) {
//        int d = 1, f = 6, target = 3;
//        int d = 2, f = 5, target = 10;
        int d = 30, f = 30, target = 500;
//        int d = 2, f = 6, target = 7;
//        int d = 1, f = 2, target = 3;
        numRollsToTarget1155 tmp = new numRollsToTarget1155();
        int tmpp = tmp.numRollsToTarget(d, f, target);
        System.out.println(tmpp);
    }

    public int numRollsToTarget(int d, int f, int target) {
        if (d == 1 && f >= target) return 1;
        else if (d == 1) return 0;

        int[][] dp = new int[d][target + 1];
        for (int i = 1; i <= f; i++) {
            if (i >= target + 1) continue;
            dp[0][i] = 1;
        }

//        int start = 1, end = f;
        for (int i = 0; i < d - 1; i++) {
            for (int j = 0; j <= target; j++) {
                if (dp[i][j] == 0) continue;
                for (int k = 1; k <= f; k++) {
                    if (j + k >= target + 1) continue;
//                    System.out.println(j + " " + k + " " + (j + k));
                    dp[i + 1][j + k] += dp[i][j];
//                    end = Math.max(j + k, end);
                }
            }
//            start++;
            System.out.println(Arrays.deepToString(dp));
        }
//        System.out.println(Arrays.toString(dp[d - 1]));
        return dp[d - 1][target] % (10 ^ 9 + 7);
    }
}
