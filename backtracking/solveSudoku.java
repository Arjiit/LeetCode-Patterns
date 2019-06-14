class Solution {
    public void solveSudoku(char[][] board) {
     if (solveSudokuCell(0,0,board)){
         
     }
    }
    
    public static boolean solveSudokuCell(int row, int col, char[][] board) {
        
        if (col == board[row].length) { // when we are finished with placement in all the column in
            // first row
            col = 0;
            row++;
        }
        
        if (row == board.length) { // if we have filled all the rows in the board.
            return true;
        }
        
        // skipping filled entries
        
        if (board[row][col] != '.') {
          return solveSudokuCell(row, col+1, board);
        }
        
        // trying all values 1 to 9 for a particular (row,col)
        
        for (int value=1; value <= board.length; value++) {
            char charToPlace = (char) (value + '0');
            
            // apply contraints
            if (canPlace(board, row, col, charToPlace)) {
                board[row][col] = charToPlace;
                if (solveSudokuCell(row, col+1,board)) {
                    return true;
                }
            }
        }
        
        // undo assignment if no values worked
        board[row][col] = '.';
        return false;
    }
    
    public static boolean canPlace(char[][] board, int row, int col, char charToPlace) {
        
        for (char[] element: board) { // check on single column...top to bottom
            if (charToPlace == element[col]) {
                return false;
            }
        }
        
        for (int i=0; i< board.length; i++) { //check on single row...left to right
            if (charToPlace == board[row][i]) {
                return false;
            }
        }
        
        int regionSize = (int) Math.sqrt(board.length);
        int I = row/regionSize;
        int J = col/regionSize;
        
        int topLeftsSubBoxRow = regionSize*I;
        int topLeftsSubBoxCol = regionSize*J;
        
        for (int i=0; i<regionSize; i++) {
            for (int j=0; j< regionSize; j++) {
                if (charToPlace == board[topLeftsSubBoxRow+i][topLeftsSubBoxCol+j]) {
                    return false;
                }
            }
        }
        return true; // placement is valid
    }
}