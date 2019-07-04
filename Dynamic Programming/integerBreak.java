class Solution {
    public int integerBreak(int n) {
        /* 
        we can maintain a DP array where at each index we can store the max
        product that can be achieved for that integer index. So, there are 
        two possibilities - for eg: 10 = 3*7 or 3*dp[10-3], since dp[7] will
        store the max product possible with number 7. Obviously, we would 
        want different combiantions of making sum 10 i.e. 2,8 or 5,5 and we
        would want max of those,hence dp[i] = Math.max(dp[i],Math.max(j, dp[j])*Math.max(i-j, dp[i-j]))
        or
        dp[i] = Math.max(dp[i], (i-j)*j);
        dp[i] = Math.max(dp[i], dp[j]*(i-j))
        */
        int[] dp = new int[n+1];
        
        for (int i=1; i<=n; i++){ // taking one index at a time
            for(int j=1; j<=i; j++){ // finding possible numbers uptill index i
                dp[i] = Math.max(dp[i], (i-j)*j); // ensuring max value amongst dp[i] updated from last iteration of j
                dp[i] = Math.max(dp[i], dp[j]*(i-j)); // ensuring max value from line above
                // can also be dp[i] = math.max(dp[i], dp[i-j]*j), doesn't matter
                
            }
        }
        return dp[n];
    }
}