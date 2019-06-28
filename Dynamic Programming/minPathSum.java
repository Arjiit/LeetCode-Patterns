class Solution {
    
    /*
    Either we can start from (0,0) or the end (2,2) and find minimum distance to reach the final step. the rest of the grid[i][j] (for all i >1 and j >1) find the minimum of the grid-left (j-1) and grid-top (i-1) value and add to the current grid value. At the end, the minimum path sum would be the buttom last value in the grid. If we started from end, it would have been top most value.
    */
    public int minPathSum(int[][] grid) {
        
        for(int i=1; i<grid.length; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for(int j=1; j<grid[0].length; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }
        for(int i=1; i<grid.length; i++) {
            for(int j=1; j<grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}