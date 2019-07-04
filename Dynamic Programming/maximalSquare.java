class Solution {
    public int maximalSquare(char[][] matrix) {
        /*
        subproblem - largest square possible at each cell.
        so, for the first row and the first column, the values would be same as cell values.
        for the rest of the cells, if the cell is 1, it would be 
        1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) value.
        */
        if (matrix.length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for (int i=0; i< matrix.length; i++){
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
        }
        
        
        for (int i=0; i< matrix[0].length; i++){
            dp[0][i] = Character.getNumericValue(matrix[0][i]);
        }
        int res = 0;                      
        for (int i=0; i< matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++){
                if (i == 0 || j == 0) {
                    dp[i][j] = Character.getNumericValue(matrix[i][j]);
                }
                else if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                } else {
                    dp[i][j] = 0;
                }
                
                res = Math.max(res, dp[i][j]);
            }
        }
        for (int i=0; i< dp.length; i++){
            for (int j=0; j< dp[0].length; j++) {
                System.out.println(dp[i][j]);
            }
        }
        return res*res;
    }
}