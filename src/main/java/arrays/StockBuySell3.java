package arrays;

public class StockBuySell3 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int price1 = Integer.MAX_VALUE;
        int price2 = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;
        for (int i = 0; i < prices.length; i++) {
            price1 = Math.min(price1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - price1);
            price2 = Math.min(price2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - price2);
        }
        return profit2;
    }
}
