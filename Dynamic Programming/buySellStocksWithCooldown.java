class Solution {
    public int maxProfit(int[] prices) {
        /*
        Goal : To maximize profit at each step. At each step we could either buy the stock
        or sell. If we sell, we can't do anything next day. So, if we buy on ith day, then
        we would have selled on i-2th day.
        So, we could have a 2d DP array with i representing day, and j representing if we
        have stock (1) or not(0).
        buying means (-ve of prices[i]) and selling means positive.
        base cases: dp[0][0] - max profit on day 0 with 0 stock in hand = 0
        dp[0][1] - max profit on day 1 with 1 stock in hand = -prices[0]
        
        dp[1][0] - max profit on day 1 with 0 stock in hand = either buy a stock on day 0
        and sell it on day 1 or do nothing on day 1 = max(dp[0][1] + prices[1], 0)
        dp[1][1] - max profit on day 1 with 1 stock in hand = either buy a stock on day 0
        and do nothing on day 1 or do nothing on day 0 and buy a stock on day 1 = max(dp[0][1], - prices[1])
        
        recurrence relation/ transition: dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
        */
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        
        int dp[][] = new int [n][n];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][1] + prices[1], 0);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        
        for (int i=2; i < n; i++){
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}