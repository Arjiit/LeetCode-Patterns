class Solution {
    public int getMoneyAmount(int n) {
        /*
        This problem can be solved by maintaining a 2d DP table. 
        subproblem - dp[i][j] - representing minimum money required to guarentee a win for a number
        picked between i to j.
        dp[i][i] will always be 0 as the first number we choose would be the correct guess.
        For others, if we choose a number k which would lie between i to j, we would pay k plus
        the worst out of left of k or right of k. i.e. max(dp[k-i][j], dp[i][j-k])
        Hence for every k between i to j, since we want the minimum money to guarentee a win
        dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[k-i][j], dp[i][j-k]))
        
        To accumulate solution for 1 to n, we have to get solutions for every subproblem inside it
        like 2 to 3, 4 to 8 etc., hence we have different lengths to consider from (1 to max of n)
        Also, after we choose a particular k, we can either go on the left or the right of k, hence
        there are two subproblems and each subproblem takes O(n) to solve, hence TC - O(n^3) 
        */
        
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len < n; len++) {
            for (int from = 1, to = from + len; to <= n; from++, to++) {
                dp[from][to] = Integer.MAX_VALUE;
                for (int k = from; k <= to; k++)
                    dp[from][to] = Math.min(dp[from][to], k + Math.max(dp[from][k - 1], dp[k + 1][to]));
            }
        }
        return dp[1][n];
    }
}