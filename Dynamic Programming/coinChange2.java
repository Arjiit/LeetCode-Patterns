class Solution {
    public int change(int amount, int[] coins) {
        /*
        here we are trying to find the no of ways to make the sum upto a certain amount
        and storing that in the array. We subtract from coins array as we can use unlimited 
        number of coins.
        bottom  up approach
        */
        /*
        Form a 2d array and each row consider addition of another new coin
        and for each cell ask the question 'if you do use the additional coin or if you don't use'
        so, we have dp[row][col] = dp[row-1][col] + dp[row][col - coins[row-1]]
        */
        int[] dp = new int[amount + 1];
        dp[0] = 1; // no of ways to make sum equal to 0
            
        for (int i=0; i < coins.length; i++) {
            for (int j=1; j<amount + 1; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}