import java.util.Arrays;

public class integerBreak343 {
    public static void main(String[] args) {
        integerBreak343 tmp = new integerBreak343();
        tmp.integerBreak(10);
    }

    public int integerBreak(int n) {
        if (n < 3) return 1;
        else if (n==3) return 2;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(i + 1, Math.max(dp[i], dp[j] * dp[i - j - 1]));
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }
}
