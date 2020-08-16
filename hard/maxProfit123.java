import java.net.Inet4Address;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class maxProfit123 {
    public static void main(String[] args) {
//        int[] p = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
//        int[] p = new int[]{1, 2, 3, 4, 5};
//        int[] p = new int[]{7, 6, 4, 3, 1};
//        int[] p = new int[]{6, 1, 3, 2, 4, 7};
//        int[] p = new int[]{1,2,4,2,5,7,2,4,9,0};
//        int[] p = new int[]{6, 5, 4, 8, 6, 8, 7, 8, 9, 4, 5};
//        int[] p = new int[]{5, 7, 2, 7, 3, 3, 5, 3, 0};
        int[] p = new int[]{397,6621,4997,7506,8918,1662,9187,3278,3890,514,18,9305,93,5508,3031,2692,6019,1134,1691,4949,5071,799,8953,7882,4273,302,6753,4657,8368,3942,1982,5117,563,3332,2623,9482,4994,8163,9112,5236,5029,5483,4542,1474,991,3925,4166,3362,5059,5857,4663,6482,3008,3616,4365,3634,270,1118,8291,4990,1413,273,107,1976,9957,9083,7810,4952,7246,3275,6540,2275,8758,7434,3750,6101,1359,4268,5815,2771,126,478,9253,9486,446,3618,3120,7068,1089,1411,2058,2502,8037,2165,830,7994,1248,4993,9298,4846,8268,2191,3474,3378,9625};
        System.out.println(p.length);
        System.out.println(p[35]);
        System.out.println(p[64]);
        maxProfit123 tmp = new maxProfit123();
        System.out.println(tmp.maxProfit(p));
    }

    public int maxProfit(int[] prices) {
        List<Integer> starts = new LinkedList<>();
        List<Integer> ends = new LinkedList<>();
        List<Integer> profits = new LinkedList<>();
        int i = 0;
        while (i < prices.length) {
            if (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                int j = i + 1;
                while (j < prices.length - 1 && prices[j] < prices[j + 1]) j++;
                starts.add(i);
                ends.add(j);
                profits.add(prices[j] - prices[i]);
                i = j;
            } else i++;
        }
        System.out.println(starts);
        System.out.println(ends);
        System.out.println(profits);
        if (profits.size() == 0) return 0;
        else if (profits.size() == 1) return profits.get(0);
        if (profits.size() == 2) return profits.get(0) + profits.get(1);

        int profit1 = profits.get(0), profit2 = profits.get(1);
        int buy1 = starts.get(0), sell1 = ends.get(0), buy2 = starts.get(1), sell2 = ends.get(1);
        for (int j = 2; j < starts.size(); j++) {
            int profitJ = profits.get(j);
            int startJ = starts.get(j);
            int endJ = ends.get(j);

            int case1 = prices[sell2] - prices[buy1] + profitJ;
            int case2 = prices[sell1] - prices[buy1] + prices[endJ] - prices[buy2];
            int case3 = Math.max(profit1, profit2) + profitJ;
            if (profit1 + profit2 > case1 && profit1 + profit2 > case2 && profit1 + profit2 > case3) {
                if (j == profits.size()-1) continue;
                int nextProfit = profits.get(j + 1);
                if (nextProfit <= prices[ends.get(j+1)] - prices[startJ]){
                    profits.set(j+1, prices[ends.get(j+1)] - prices[startJ]);
                    starts.set(j + 1, startJ);
                }
            } else if (case1 >= case2 && case1 >= case3) {
                sell1 = sell2;
                buy2 = startJ;
                sell2 = endJ;
            } else if (case2 >= case1 && case2 >= case3) {
                sell2 = endJ;
            } else {
                if (profit2 >= profit1) {
                    buy1 = buy2;
                    sell1 = sell2;
                }
                buy2 = startJ;
                sell2 = endJ;
            }
            profit1 = prices[sell1] - prices[buy1];
            profit2 = prices[sell2] - prices[buy2];
            System.out.println(case1 + " " + case2 + " " + case3);
            System.out.println(buy1 + " " + sell1 + " " + buy2 + " " + sell2 + " " + profit1 + " " + profit2 + " " + profits.get(j));
        }
        return profit1 + profit2;
    }

    public int maxProfitWRONG(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp2 = new int[prices.length];
        int minima = prices[0];
        int firstMaxProfit = 0;
        int curProfit = 0;

        int firstSmallProfit = 0;
        int curSmallProfit = 0;
        int smallMinima = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                smallMinima = prices[i];
                firstSmallProfit = Math.max(firstSmallProfit, curSmallProfit);
                firstSmallProfit = Math.max(firstSmallProfit, Math.max(firstMaxProfit, curProfit));
                curSmallProfit = 0;
            }
            if (prices[i] < minima) {
                minima = prices[i];
                dp2[i] = dp2[i - 1];
                firstMaxProfit = Math.max(firstMaxProfit, curProfit);
                curProfit = 0;
                continue;
            }
            curProfit = Math.max(curProfit, prices[i] - minima);
            curSmallProfit = Math.max(curSmallProfit, prices[i] - smallMinima);
            dp2[i] = Math.max(firstSmallProfit + curSmallProfit, dp2[i - 1]);
            dp2[i] = Math.max(firstMaxProfit + curProfit, dp2[i]);
            System.out.println(firstMaxProfit + " " + curProfit + " " + firstSmallProfit + " " + curSmallProfit);
            System.out.println(Arrays.toString(dp2));
        }
        return dp2[dp2.length - 1];
    }
}
