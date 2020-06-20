import com.sun.tools.javac.Main;

import java.util.Arrays;

public class mincostTickets983 {
    public static void main(String[] args) {
//        int[] days = new int[]{1, 4, 6, 7, 8, 20};
//        int[] days = new int[]{1,4,6,7,8,365};
//        int[] costs = new int[]{2, 7, 15};

        int[] days = new int[]{1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29};
        int[] costs = new int[]{3,14,50};

        mincostTickets983 tmp = new mincostTickets983();
        int s = tmp.mincostTickets(days, costs);
        System.out.println(s);
    }

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0) return 0;
        int[] dp = new int[366];
        int j = 0;
        for (int i = 1; i < 366; i++) {
            if (j == days.length) break;
            if (i == days[j]) {
                j += 1;
                dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            } else dp[i] = dp[i - 1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[days[days.length-1]];
    }
}
