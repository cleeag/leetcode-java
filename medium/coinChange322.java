import java.util.Arrays;

public class coinChange322 {
    public static void main(String[] args) {
//        int[] c = new int[]{1,2,5};
//        int a = 11;
        int[] c = new int[]{1};
        int a = 0;
        coinChange322 tmp = new coinChange322();
        tmp.coinChange(c, a);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
