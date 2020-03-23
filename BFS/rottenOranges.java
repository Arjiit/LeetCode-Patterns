class Cell {
    int x;
    int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int orangesRotting(int[][] grid) {
        Queue<Cell> q = new LinkedList<>(); 
        int count_fresh = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    Cell rottenCell = new Cell(i, j);
                    q.add(rottenCell);
                } else if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        
        if (count_fresh == 0) return 0;
        int time = 0;
        while(!q.isEmpty()) {
        time++;
        int size = q.size();
        for (int times = 0; times < size; times++) {
           Cell curCell = q.poll();
            for (int[] d: dir) {
                int new_r = d[0] + curCell.x;
                int new_c = d[1] + curCell.y;
                if (new_r >=0 && new_c >= 0 && new_r < grid.length && new_c < grid[0].length && (grid[new_r][new_c] == 1)) {
                    Cell newCell = new Cell(new_r, new_c);
                    grid[new_r][new_c] = 2;
                    q.add(newCell);
                    count_fresh--;
                }
            }
        }
        }
        if (count_fresh != 0) return -1;
        return time == 0 ? -1: time-1;
    }
}