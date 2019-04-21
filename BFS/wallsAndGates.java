class Solution {
    public void wallsAndGates(int[][] rooms) {
        /*
        here since we want distance from nearest O for all INF cells, we do a BFS intitating at
        0 and if we encounter INF we fill the matrix by + 1 value.
        if its a non-INF value then we skip
        */
        
     int empty = Integer.MAX_VALUE;
        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        for(int i=0; i< rooms.length; i++) {
            for (int j=0; j< rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        while(row.size() != 0) {
            int r = row.poll();
            int c = col.poll();
            
            for (int i=0; i< x.length; i++) {
                int new_r = r + x[i];
                int new_c = c + y[i];
                if (new_r < 0 || new_r >= rooms.length || new_c < 0 || new_c >= rooms[0].length || rooms[new_r][new_c] != empty) {
                    continue;
                }
                row.add(new_r);
                col.add(new_c);
               // System.out.println("NEW ROW " + new_r)
                rooms[new_r][new_c] = rooms[r][c] + 1; //increasing the length by adding one to where we started BFS from.
            }
        }
    }
}