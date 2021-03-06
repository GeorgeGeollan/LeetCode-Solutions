class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;

        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];

            if(profit < 0)
                continue;

            else
                sum += profit;
        }

        return sum;
    }
}
