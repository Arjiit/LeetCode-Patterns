class Solution {
    /*
    on the first row or first column, if there is a obstacle, then we can't move further,
    hence we break out. If the cell in the middle is an obstacle, we don't update or mark it
    as 0 (dp[i][j] = 0), because we don't want to add the paths to reach there to update
    our further cells.
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        
        for (int i=0; i< dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        
        for (int j=0; j < dp[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                dp[0][j] = 1;
            }
        }
        
        for (int i=1; i < dp.length; i++) {
            for (int j=1; j < dp[0].length; j++){
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}