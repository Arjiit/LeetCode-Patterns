class Solution {
    public int change(int amount, int[] coins) {
        /*
        here we are trying to find the no of ways to make the sum upto a certain amount
        and storing that in the array. We subtract from coins array as we can use unlimited 
        number of coins.
        bottom  up approach
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