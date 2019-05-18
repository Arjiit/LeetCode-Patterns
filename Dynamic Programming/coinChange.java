class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // so that when dp[j-coins[i]] becomes 0 we return 0. Since we have found the
        // total coins needed for the sum.
        /*
        for each coin we will look if we can form a minimum amount for amount ranging from 0 to
        amount.
        T[i] = min(T[i], 1 + T[i-coin])
        minimum way to pick a amount = minimum(current way present to pick, if we pick the coin and then way to pick the remaining i.e. total - coin)
        */
        for(int i=0; i<coins.length; i++) {
            for (int j = 1; j< amount+1; j++) {
                if (coins[i] > j) {
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }
     return dp[amount] > amount ? -1: dp[amount]; 
    }
    
}