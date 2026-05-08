import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k <= 0) return 0;

        // Optimization: If k is large enough, it's just Stock II
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // buy[i] tracks balance after i-th buy, sell[i] tracks profit after i-th sell
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // Initialize buy states to negative infinity
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                // Update buy state: previous sell profit minus current price
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                // Update sell state: current buy balance plus current price
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k];
    }
}
