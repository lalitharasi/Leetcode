class Solution {
    public int maxProfit(int[] prices) {
        // Initialize balances
        // buy1 and buy2 are negative because they represent spending money
        int buy1 = Integer.MIN_VALUE; 
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            // 1. Maximize balance after 1st buy (lowest price)
            buy1 = Math.max(buy1, -price);
            
            // 2. Maximize profit after 1st sell
            sell1 = Math.max(sell1, buy1 + price);
            
            // 3. Maximize balance after 2nd buy (reinvest sell1 profit)
            buy2 = Math.max(buy2, sell1 - price);
            
            // 4. Maximize final profit after 2nd sell
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
