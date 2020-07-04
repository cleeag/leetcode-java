import java.util.Arrays;

public class minSteps650 {
    public static void main(String[] args) {
        minSteps650 tmp = new minSteps650();
        tmp.minSteps(10);
    }

    public int minSteps(int n) {
        if (n == 1) return 0;
        else if (n <= 3) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[i], i);
            int j = 2;
            while ((i * j) <= n) {
                dp[i * j] = Math.min(dp[i * j], dp[i] + (j - 1) + 1);
                j++;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}
