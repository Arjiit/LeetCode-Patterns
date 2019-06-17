class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word: words) {
        for (int i=0; i< board.length; i++){
        for (int j=0; j< board[0].length; j++){
            if (dfs(board, i, j, word, 0) && !res.contains(word)){
                res.add(word);
                }
            }
        }
    }
        return res;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return false;
        }
        
        if (board[i][j] == word.charAt(index++)) {
           // System.out.println(board[i][j]);
            char c = board[i][j];
            board[i][j] = '#';
            boolean ret = dfs(board, i+1, j, word, index) || dfs(board, i, j+1, word, index) || dfs(board, i-1, j, word, index) || dfs(board, i, j-1, word, index);
            board[i][j] = c;
            return ret;
        }
        return false;
    }
}
