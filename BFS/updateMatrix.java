class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        /*
        since we want shortest path from 0, we add all 0 in the matrix to Queue
        because then we will be able to a bfs at each cell with 0 and whenever we
        see a 1 we update the matrix with distance and also put the cell in Queue to 
        do a bfs on it later.
        */
        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        
        for (int i=0; i< matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        while(!row.isEmpty()) {
            int r = row.poll();
            int c = col.poll();
            
            for (int i=0; i<x.length; i++) {
                int new_r = r + x[i];
                int new_c = c + y[i];
                if (new_r >=0 && new_r < matrix.length && new_c >= 0 && new_c < matrix[0].length && matrix[new_r][new_c] == 1 && !visited[new_r][new_c]) {
                    matrix[new_r][new_c] = 1 + matrix[r][c];
                    visited[new_r][new_c] = true;
                    row.add(new_r);
                    col.add(new_c);
                }
            }
        }
        return matrix;
    }
}