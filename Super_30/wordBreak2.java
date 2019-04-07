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

/*
 
 using Trie


*/


 class TrieNode{
    TrieNode[] children;
    String word;
    TrieNode(){
        children=new TrieNode[26];
    }
}
class Solution {
    TrieNode root=new TrieNode();
    Set<String> res=new HashSet<>();

    
    public void insert(String word){
        TrieNode t=root;
        for(char c:word.toCharArray()){
            if(t.children[c-'a']==null){
                t.children[c-'a']=new TrieNode();
            }
            t=t.children[c-'a'];
        }
        t.word=word;
    }



    public void find(char[][] board,int i,int j,int row,int col,TrieNode t,boolean[][] visited){
        if(i>=0&&i<row&&j>=0&&j<col){
            if(!visited[i][j]){
                if(t.children[board[i][j]-'a']!=null){
                    visited[i][j]=true;
                    if(t.children[board[i][j]-'a'].word!=null) res.add(t.children[board[i][j]-'a'].word);
                    find(board,i-1,j,row,col,t.children[board[i][j]-'a'],visited);
                    find(board,i+1,j,row,col,t.children[board[i][j]-'a'],visited);
                    find(board,i,j-1,row,col,t.children[board[i][j]-'a'],visited);
                    find(board,i,j+1,row,col,t.children[board[i][j]-'a'],visited);
                    visited[i][j]=false;
                }
            }
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words) insert(word);
        int row=board.length;
        int col=board[0].length;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                TrieNode t=root;
                if(t.children[board[i][j]-'a']==null) continue;
                else{
                    find(board,i,j,row,col,t,visited);
                }
            }
        }
        return new ArrayList<String>(res);
    }
}