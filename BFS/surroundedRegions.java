class Solution {
    
    /*
    Catch is not to make the 0 that are connected to boundary 0 as X.
    So, we would want to do a BFS on boundary O and check if adjacent cells are O or not.
    */
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[0].length; j++){
                if((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && (board[i][j] == 'O')) {
                    row.add(i); // push all boundary O so that we can pop and do BFS on it.
                    col.add(j);
                }
            }
        }
    
        while(!row.isEmpty()) {
            int r = row.poll(); 
            int c = col.poll();
        
                
                if ((r >= 0) && (c >= 0) && (r < board.length) && (c < board[0].length) && (board[r][c] == 'O')) { // check if its O or not
                    board[r][c] = 'D'; // if it is mark it as D.
                for (int i=0; i< x.length; i++) {
                   int new_r = r + x[i]; // check for neighbours and put inside queue.
                   int new_c = c + y[i];
                    row.add(new_r);
                    col.add(new_c);                    
                } 
            } // since we don't use board[i][j] anywhere we are not concerned if new_r and new_c are out of bounds or not. we take care of it at the top.
                

        }
            
        
        for (int i=0; i < board.length; i++) {
            for (int j=0; j< board[0].length; j++) { // in the end since we did BFS on boundary O. All the cells connected to those will have turned to D and so we replace D by 0.
                if (board[i][j] == 'O') { // remaining will be interior O which we convert back to X.
                    board[i][j] = 'X';
                } else if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                } else {
                    continue;
                }
            }
        }
        
    }
}