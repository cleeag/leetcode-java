import java.util.*;

public class longestWPI1124 {
    public static void main(String[] args) {
//        int[] h = new int[]{9, 9, 6, 0, 6, 6, 9, 9, 9, 9};
        int[] h = new int[]{9, 9, 6, 0, 6, 6};
//        int[] h = new int[]{6, 6, 6};
//        int[] h = new int[]{9, 9, 9};
        longestWPI1124 tmp = new longestWPI1124();
        tmp.longestWPI(h);
    }

    public int longestWPI(int[] hours) {
        int wpi = 0;
        int n = hours.length;
        int[] earliest = new int[n  * 2 + 1];
        int[] preSum = new int[n + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(earliest, n);
        earliest[n] = 0;
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            earliest[n + preSum[i]] = Math.min(earliest[n + preSum[i]], i);
            if (n + preSum[i] - 1 > 0 && earliest[n + preSum[i] - 1] != n) {
                System.out.println(i);
                System.out.println(i - earliest[n + preSum[i] - 1]);
                dp[i] = dp[earliest[n + preSum[i] - 1]] + i - earliest[n + preSum[i] - 1];
                wpi = Math.max(wpi, dp[i]);
            }
            System.out.println(Arrays.toString(preSum));
            System.out.println(Arrays.toString(earliest));
            System.out.println();
        }
        System.out.println(wpi);
        return wpi;
    }
}
