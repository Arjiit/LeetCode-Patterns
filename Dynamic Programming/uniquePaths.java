class Solution {
    public int uniquePaths(int m, int n) {
        /*
        we can see this as number of ways to reach a particular cell. For all the cells in the first row and 
        for all the cells in the first columns, no of ways to reach is 1. For rest of the cells, the number
        of ways to reach to them is number of way to reach from top plus number of ways to reach from the left.

        */
        int[][] dp = new int[m][n];
        
        
        for (int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        
        
        for (int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        
        for (int i=1; i < dp.length; i++){
            for (int j=1; j < dp[i].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}