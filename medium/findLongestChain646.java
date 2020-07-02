import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class findLongestChain646 {
    public static void main(String[] args) {
//        int[][] p = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int[][] p = new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        findLongestChain646 tmp = new findLongestChain646();
        tmp.findLongestChain(p);
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 1) return pairs.length;
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(pairs));

        int globalMax = 0;
        for (int i = 0; i < pairs.length; i++) {
            System.out.println(Arrays.toString(pairs[i]));
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                globalMax = Math.max(globalMax, dp[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return globalMax;
    }

}
