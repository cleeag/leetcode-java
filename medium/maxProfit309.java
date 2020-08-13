public class maxProfit309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int days = prices.length;
        int[] buy = new int[days + 1];
        int[] sell = new int[days + 1];
        int buyMax = -prices[0], sellMax = 0;
        for (int i = 2; i < prices.length + 1; i++) {
            buy[i] = sellMax - prices[i - 1];
            sell[i] = buyMax + prices[i - 1];
            buyMax = Math.max(buyMax, buy[i]);
            sellMax = Math.max(sellMax, sell[i - 1]);
        }
        return Math.max(sellMax, sell[sell.length-1]);
    }
}
