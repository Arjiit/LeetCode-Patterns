class Solution {
    public int maxProfit(int[] prices, int fee) {
        /*
        At any stage we can either have the stock or not have it. This forms the basis of 
        forming our recurrence relation.
        hold[i][k]  ith day k transaction have stock and maximum profit
        unhold[i][k] ith day k transaction do not have stock at hand and maximum profit
        Also, if (k > prices.length/2) - then we can follow solution from Best Time to Buy and Sell           Stock II that is follow a greedy like approach and buy sell as many times since (buy,sell)
        comprises as 1 transaction. We add a fee when we unhold i.e. when we sell the stock.
        At each cell, we want to maximize the profit.
        */

        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        hold[0] = -prices[0];
        
        
        for (int i=1; i< prices.length; i++){
                hold[i] = Math.max(unhold[i-1] - prices[i], hold[i-1]);
                unhold[i] = Math.max(unhold[i-1], hold[i-1] + prices[i]- fee);
        }
        return unhold[prices.length-1];
        
    }
    
    public int maxP(int[] prices) {
        int tot = 0;
        
        for (int i=0; i< prices.length; i++) {
            if (i > 0 && prices[i] > prices[i-1]) {
                         tot = tot + (prices[i] - prices[i-1]);   
            }
        }
        return tot;
    }
}