class Solution {
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< board.length; i++) {
            for (int j=0; j<board[0].length; j++){
                if (dfs(board, i, j, word, 0)) {
                    return true;
            }
            }
    }
        return false;
    }
    /*
    Do a DFS to find the next element and store result in res.
    Change back
    */
    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        
        if (index >= word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        if (board[i][j] == word.charAt(index++)) {
            char c = board[i][j];
            //System.out.println("Before DFS " + c);
            board[i][j] = '#'; // marking the cell as visited
            boolean res = dfs(board, i+1, j, word, index) || dfs(board, i, j+1, word, index) || dfs(board, i-1, j, word, index) || dfs(board, i, j-1, word, index);
            //System.out.println(res);
            board[i][j] = c; // marking the cell as unvisited, incase if it doesn't work out
            //System.out.println("After DFS " + c);
            return res;
        }
        return false;
    }
}