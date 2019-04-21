class Solution{  
public boolean isValidSudoku(char[][] board) {
        Set<Character> row = null;
        Set<Character> col = null;
        
        // Check rows
        for(int r=0;r<board.length;r++) {
            row = new HashSet<>();
            for(int c=0;c<board[0].length;c++) {
                if(board[r][c]=='.')
                    continue;
                if(row.contains(board[r][c]))
                    return false;
                row.add(board[r][c]);
            }
        }
        
        // Check cols
        for(int r=0;r<board.length;r++) {
            col = new HashSet<>();
            for(int c=0;c<board[0].length;c++) {
                if(board[c][r]=='.')
                    continue;
                if(col.contains(board[c][r]))
                    return false;
                col.add(board[c][r]);
            }
        }

        // Check boxes
        for(int rowFactor=0;rowFactor<3;rowFactor++) {
            for(int colFactor=0;colFactor<3;colFactor++) {
                // Validate each box
                Set<Character> boxSet = new HashSet<>();
                for(int i=3*rowFactor;i<(3 + (3*rowFactor));i++) {
                    for(int j=3*colFactor;j<(3 + (3*colFactor));j++) {
                        if(board[i][j]=='.')
                            continue;
                        if(boxSet.contains(board[i][j]))
                            return false;
                        boxSet.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}