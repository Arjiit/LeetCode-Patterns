class TicTacToe {

    /** Initialize your data structure here. */
    private int[][] board;
    int[] rowCounter;
    int[] colCounter;
    int diagLeft;
    int diagRight;
    int n;
    public TicTacToe(int n) {
        board = new int[n][n];
        rowCounter = new int[n];
        colCounter = new int[n];
        diagLeft = 0;
        diagRight = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int move = player == 1 ? -1 : 1;
        rowCounter[row] = rowCounter[row] + move;
        colCounter[col] = colCounter[col] + move;
        
        if(row == col) {
            diagLeft = diagLeft + move;
        }
        
        if (row == n - col - 1) {
            diagRight = diagRight + move;
        }
        if (rowCounter[row] == n || colCounter[col] == n || diagLeft == n || diagRight == n) {
            return 2;
        } else if (rowCounter[row] == -n || colCounter[col] == -n || diagLeft == -n || diagRight == -n) {
            return 1;
        } else {
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */class TicTacToe {

    /** Initialize your data structure here. */
    private int[][] board;
    int[] rowCounter;
    int[] colCounter;
    int diagLeft;
    int diagRight;
    int n;
    public TicTacToe(int n) {
        board = new int[n][n];
        rowCounter = new int[n];
        colCounter = new int[n];
        diagLeft = 0;
        diagRight = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int move = player == 1 ? -1 : 1;
        rowCounter[row] = rowCounter[row] + move;
        colCounter[col] = colCounter[col] + move;
        
        if(row == col) {
            diagLeft = diagLeft + move;
        }
        
        if (row == n - col - 1) {
            diagRight = diagRight + move;
        }
        if (rowCounter[row] == n || colCounter[col] == n || diagLeft == n || diagRight == n) {
            return 2;
        } else if (rowCounter[row] == -n || colCounter[col] == -n || diagLeft == -n || diagRight == -n) {
            return 1;
        } else {
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */