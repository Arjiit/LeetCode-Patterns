class Solution {
    // S - start, U - Up, D - Down, O- out of bound/0, R- Right, L-Left
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                String island = dfs(grid, i, j, grid.length, grid[0].length, "S"); 
                    set.add(island);
                }
            }
        }
        return set.size();
    }
    
    public String dfs(int[][] grid, int row, int col, int m, int n, String dir) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return "O";
        }
        grid[row][col] = 0;
        String left = dfs(grid, row, col-1, m, n, "L");
        String up = dfs(grid, row-1, col, m, n, "U");
        String down = dfs(grid, row+1, col, m, n, "D");
        String right = dfs(grid, row, col+1, m, n, "R");
        
        return dir + left + up + down + right;
    }
}