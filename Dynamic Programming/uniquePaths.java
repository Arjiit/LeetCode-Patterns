class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        dp[0][0] = 1;
        for (int i=1; i<m; i++){
            dp[i][0] = 1;
        }
        
        
        for (int j=1; j<n; j++){
            dp[0][j] = 1;
        }
        
        for (int i=1; i < m; i++){
            for (int j=1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}