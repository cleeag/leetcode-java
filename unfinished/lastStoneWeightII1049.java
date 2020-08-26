import java.util.Arrays;

public class lastStoneWeightII1049 {
    public static void main(String[] args) {
//        int[] s = new int[]{2, 7, 4, 1, 8, 1};
//        int[] s = new int[]{1,9};
//        int[] s = new int[]{1};
        int[] s = new int[]{1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98};
        lastStoneWeightII1049 tmp = new lastStoneWeightII1049();
        tmp.lastStoneWeightII(s);
    }

    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1) return stones[0];
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) sum += stone;
        System.out.println(sum);
        int halfSum = sum / 2;
        int maxL = 1;
        int[][] dp = new int[n + 1][halfSum + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < halfSum + 1; j++) {
                if (j - stones[i - 1] >= 0) dp[i][j] = dp[i - 1][j - stones[i - 1]];
                if (dp[i][j] == 1) maxL = Math.max(maxL, j);
            }
            System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
        }
        System.out.println(dp[0].length);
        System.out.println(maxL);
        System.out.println(sum - maxL * 2);
        return sum - maxL * 2;
    }
}
