class Solution {
    public int maxProfit(int[] prices) {
        /*
        At any stage we can either have the stock or not have it. This forms the basis of 
        forming our recurrence relation.
        hold[i][k]  ith day k transaction have stock and maximum profit
        unhold[i][k] ith day k transaction do not have stock at hand and maximum profit
        Also, if (k > prices.length/2) - then we can follow solution from Best Time to Buy and Sell           Stock II that is follow a greedy like approach and buy sell as many times since (buy,sell)
        comprises as 1 transaction.
        At each cell, we want to maximize the profit.
        */
        int k = 2;
        if (k > prices.length/2) {
            return maxP(prices);
        }
        int[][] hold = new int[prices.length][k+1];
        int[][] unhold = new int[prices.length][k+1];
        hold[0][0] = -prices[0];
        
        for (int i=1; i<prices.length; i++) {
            hold[i][0] = Math.max(hold[i-1][0], -prices[i]); // at first transaction to hold, we can either take the previous one as is or select the current one
        }
        
        for (int i=1; i<= k; i++){
            hold[0][i] = -prices[0]; 
        }
        
        for (int i=1; i< prices.length; i++){
            for (int j=1; j<=k; j++){
                hold[i][j] = Math.max(unhold[i-1][j] - prices[i], hold[i-1][j]);
                unhold[i][j] = Math.max(unhold[i-1][j], hold[i-1][j-1] + prices[i]);
            }
        }
        return unhold[prices.length-1][k];
        
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