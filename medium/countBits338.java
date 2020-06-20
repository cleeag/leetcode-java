import java.util.Arrays;

public class countBits338 {
    public static void main(String[] args) {
        int num = 8;
        countBits338 tmp = new countBits338();
        tmp.countBits(num);
    }

    public int[] countBits(int num) {
        if (num == 0) return new int[] {0};
        if (num == 1) return new int[] {0, 1};
        if (num == 2) return new int[] {0, 1, 1};
        if (num == 3) return new int[] {0, 1, 1, 2};

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        int curPower = 3;
        for (int i = 4; i < num + 1; i++) {
            if (i >= (int) Math.pow(2, curPower)) curPower += 1;
            if (i < (int) Math.pow(2, curPower)) {
                dp[i] = dp[i - (int) Math.pow(2, curPower - 1)] + 1;
            }
            System.out.println(curPower);
            System.out.println(Arrays.toString(dp));
        }
        return dp;
    }
}
