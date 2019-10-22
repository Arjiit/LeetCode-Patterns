
/*
	To find who is the winner, we can go through the board and find out if it has all crosses or not. This will be O(n^2) operation.
	But we can pre-compute the places and determine it in O(1) time as the winner can only be a player who is making the move and
	we can use this fact to determine the winner in O(1) time.

	Usage :
	TicTacToe game = new TicTacToe();
	game.placeMark(0,2);
	game.printBoard();
	if (game.checkForWin()) {
		System.out.println("We have a winner!");
	}

	if (game.isBoardFull()) {
		System.out.println("Game is a draw!");
	}

	game.changePlayer();
*/
public class TicTacToe {

	private char[][] board;
	private char currentPlayer;

	public TicTacToe() {
		board = new int[3][3];
		currentPlayer = 'X';
		initializeBoard();
	}

	// reset board to empty values
	public void initializeBoard() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				board[i][j] = '-';
			}
		}
	}

	// check if board is full

	public boolean isBoardFull() { // no need to pass board as we have board globally initialized
		boolean isFull = true;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j< board[0].length; j++) {
				if (board[i][j] == '-'){
					isFull = false;
				}
			}
		}
		return isFull;
	}


	// check for win

	public boolean chechkForWin() {
		return (checkRowsForWin() || checkColsForWin() || checkDiagonalsForWin());
	}

	public boolean checkRowsForWin() {
		for (int i=0; i<3; i++) {
			if (checkForWin(board[i][0], board[i][1], board[i][2])) {
				return true;
			}
		}
		return false;
	}

	public boolean checkColsForWin() {
		for (int i=0; i<3; i++) {
			if (checkForWin(board[0][i], board[1][i], board[2][i])) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonalsForWin() {
		return (checkForWin(board[0][0], board[1][1], board[2][2]) || chechkForWin(board[0][2], board[1][1], board[2][0]));
	}

	public boolean chechkForWin(char c1, char c2, char c3) {
		return ((c1 != '-')&&(c1 == c2)&&(c2==c3));
	}


	// change player while playing
	public void changePlayer() {
		if (currentPlayer == 'X') {
			currentPlayer = 'O';
		} else {
			currentPlayer = 'X';
		}
	}

	// place mark at a particular position in board
	public boolean placeMark(int row, int col) {
		if (row >= 0 && row < 3) {
			if (col >=0 && col < 3){
				if (board[row][col] == '-') {
					board[row][col] = currentPlayer;
					return true;
				}
			}
		}
		return false;
	}

	// print the board
	public void printBoard() {
		System.out.println("------------");
		for (int i=0; i < 3; i++){
			System.out.println("|");
			for (int j=0; j<3; j++) {
				System.out.println(board[i][j] + "|");
			}
			System.out.println();
			System.out.println("------------");
		}
	}

}