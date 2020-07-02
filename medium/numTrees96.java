import java.util.Arrays;

public class numTrees96 {
    public static void main(String[] args) {
        numTrees96 tmp = new numTrees96();
        tmp.numTrees(4);
    }

    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] * 2;
            for (int j = 1; j < i; j++) {
                System.out.println(i + " " + j);
                dp[i] += dp[j - 1] * dp[i - j -1];
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
