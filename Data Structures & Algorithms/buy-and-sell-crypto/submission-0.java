class Solution {
    public int maxProfit(int[] prices) {
        // Handle edge cases
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE; // Initialize to the highest possible value
        int maxProfit = 0; // Initialize to 0, as we can't have negative profit

        for (int i = 0; i < prices.length; i++) {
            // Update the minimum price if a lower one is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Calculate profit if sold today, and update maxProfit if it's higher
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}