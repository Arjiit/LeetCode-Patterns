class Solution {
    public boolean divisorGame(int N) {
        /*
        We can form a Dp array to store the results of Alice and when we leave something,
        after choosing we check if the array table for that number is false.
        Each index of DP array will represent the result of the game for a given number i
        and we will fill the table upto N.
        */
        
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = false; // since when one is left the player loses
        
        // Filling the table bottom up
        for (int i=2; i<=N; i++) { // for every index in DP array
            for (int j=1; j < i; j++){ // since x can go from 1 to N (1 to i)
                if (i % j == 0) {
                    if (dp[i-j] == false) {
                        // then Alice wins
                        dp[i] = true;
                        break; // we break out and fill the value for different number (i)
                    }
                }
            }
        }
        return dp[N];
    }
}