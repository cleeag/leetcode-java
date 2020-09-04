import java.util.Arrays;

public class maxProfit714 {
    public static void main(String[] args) {
        int[] p = new int[]{1, 3, 7, 5, 10, 3};
        int f = 3;
        maxProfit714 tmp = new maxProfit714();
        tmp.maxProfit(p, f);
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int maxBuy = -prices[0];
        int maxSell = 0;
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            maxBuy = Math.max(maxBuy, maxSell - prices[i]);
            maxSell = Math.max(maxSell, maxBuy + prices[i] - fee);
            maxProfit = Math.max(maxSell, maxProfit);
        }
        return maxProfit;
    }

    public int maxProfitREDUNDANT(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0];
        int maxBuy = -prices[0];
        int maxSell = 0;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            buy[i] = maxSell - prices[i];
            sell[i] = maxBuy + prices[i] - fee;
            maxBuy = Math.max(maxBuy, buy[i]);
            maxSell = Math.max(maxSell, sell[i]);
            maxProfit = Math.max(maxSell, maxProfit);
            System.out.println(Arrays.toString(buy));
            System.out.println(Arrays.toString(sell));
            System.out.println(maxProfit);
        }
        return maxProfit;
    }
}
