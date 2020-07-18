public class maxProfit309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        else if (prices.length == 1) return prices[0];
        int[] dp = new int[prices.length];
        int profitTime = 0;
        int buy = -1, prevSell = -1, profit = 0;
        boolean bought = false;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i + 1] >= prices[i] && !bought) {
                buy = i;
                bought = true;
            } else if (prices[i + 1] < prices[i] && bought) {
                prevSell = i;
                bought=false;


            }
        }
        return 0;
    }
}
