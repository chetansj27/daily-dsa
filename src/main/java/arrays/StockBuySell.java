package arrays;

//Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int cost = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (cost > prices[i]) {
                cost = prices[i];
            }
            if (prices[i] - cost > profit) {
                profit = prices[i] - cost;
            }
        }
        return profit;
    }
}
