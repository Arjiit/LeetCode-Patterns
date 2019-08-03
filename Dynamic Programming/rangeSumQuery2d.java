class NumMatrix {
    /*
    T.C. for one query is O(1)
    */
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = 0;
        int col = 0;
        if (matrix.length != 0) {
            row = matrix.length;
            col = matrix[0].length;
        }
        dp = new int[row+1][col+1];
        
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                // filling up sum of boxes from (0,0) to (i-1,j-1) at dp[i][j]
                // vertical box value + horizontal box value + current box value of matrix - (value that included twice) 
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1]; 
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        row2++;
        col1++;
        col2++;
        
        return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
