import java.util.Arrays;

public class change518 {
    public static void main(String[] args) {
//        int a = 5;
//        int[] coins = new int[]{1,2,5};
        int a = 10;
        int[] coins = new int[]{10};
        change518 tmp = new change518();
        tmp.change(a, coins);
    }
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        int[][] dp = new int[coins.length][amount + 1];
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) dp[i][0] = 1;

        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j - coins[i] == 0) dp[i][j] = 1;
                else if (j - coins[i] > 0) {
                    for (int k = 0; k <= i; k++) {
                        dp[i][j] += dp[k][j - coins[i]];
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }

        int ans = 0;
        for (int i = 0; i < coins.length; i++) ans += dp[i][dp[0].length-1];
        System.out.println(ans);
        return ans;
    }

    public int changeTLE(int amount, int[] coins) {
        return dfs(amount, coins, 0, 0);
    }

    public int dfs(int amount, int[] coins, int index, int curSum) {
        System.out.println(index + " " + curSum);
        if (curSum > amount) return 0;
        else if (curSum == amount) return 1;

        int ways = 0;
        for (int i = index; i < coins.length; i++) {
            ways += dfs(amount, coins, i, curSum + coins[i]);
        }
        return ways;
    }
}
