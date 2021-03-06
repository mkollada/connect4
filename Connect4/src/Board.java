
public class Board {
	Piece[][] board = new Piece[7][6];
	int cols;
	int rows;
	
	public Board() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = new Piece();
			}
		}
		cols = board.length;
		rows = board[0].length;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
	
	public Piece[][] changeBoardAtPosition(int x, int y, Piece p) {
		board[x][y] = p;
		return board;
	}
	
	public Boolean rowSettledForColumn(int column, Piece p) {
		for(int row = 0; row < 6; row++) {
			if(board[column][row].getColorCode() == 0) {
				changeBoardAtPosition(column,row,p);
				return true;
			}
		}
		return false;
	}
	
	//check if there is a winner going vertically
	public int checkVertical() {
		int currPlayer = 0;
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j < rows-3; j++) {
				currPlayer = board[i][j].getColorCode();
				if(board[i][j+1].getColorCode() == currPlayer && currPlayer != 0) {
					if(board[i][j+2].getColorCode() == currPlayer) {
						if(board[i][j+3].getColorCode() == currPlayer) {
							System.out.println("Player " + currPlayer + " wins vertically");
							return currPlayer;
						}
					}
				}
				currPlayer = 0;
			}
		}
		return currPlayer;
	}
	
	//check if there is a winner going horizontally
	public int checkHorizontal() {
		int currPlayer = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols-3; j++) {
				currPlayer = board[j][i].getColorCode();
				if(board[j+1][i].getColorCode() == currPlayer && currPlayer != 0) {
					if(board[j+2][i].getColorCode() == currPlayer) {
						if(board[j+3][i].getColorCode() == currPlayer) {
							System.out.println("Player " + currPlayer + " wins horizontally");
							return currPlayer;
						}
					}
				}
				currPlayer = 0;
			}
		}
		return currPlayer;
	}
	
	//check if there is a winner going left diagonally
	public int checkLDiagonal() {
		int currPlayer = 0;
		for(int i = 0; i < cols-3; i++) {
			for(int j = 0; j < rows-3; j++) {
				currPlayer = board[i][j].getColorCode();
				if(board[i+1][j+1].getColorCode() == currPlayer && currPlayer != 0) {
					if(board[i+2][j+2].getColorCode() == currPlayer) {
						if(board[i+3][j+3].getColorCode() == currPlayer) {
							System.out.println("Player " + currPlayer + " wins left diagonally");
							return currPlayer;
						}
					}
				}
				currPlayer = 0;
			}
		}
		return currPlayer;
	}
	
	public Boolean checkWinner() {
		int win = checkVertical() + checkHorizontal() + checkLDiagonal() + checkRDiagonal();
		return win > 0;
	}
	
	public int checkRDiagonal() {
		int inARow = 0;
		int currPlayer = 0;
		for(int i = 3; i < cols-3; i++) {
			for(int j = 0; j < rows-3; j++) {
				currPlayer = board[i][j].getColorCode();
				if(board[i-1][j+1].getColorCode() == currPlayer && currPlayer != 0) {
					if(board[i-2][j+2].getColorCode() == currPlayer) {
						if(board[i-3][j+3].getColorCode() == currPlayer) {
							System.out.println("Player " + currPlayer + " wins right diagonally");
							return currPlayer;
						}
					}
				}
				currPlayer = 0;
			}
		}
		return currPlayer;
	}
	
	
	public String showBoard() {
		String str = "";
		int cols = board[0].length;
		int rows = board.length;
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j < rows; j++) {
				if(board[j][cols-i-1].getColorCode() == 0) {
					str += "_";
				}
				else if(board[j][cols-i-1].getColorCode() == 1) {
					str += "O";
				}
				else if(board[j][cols-i-1].getColorCode() == 2) {
					str += "X";
				}
				else {
					str += "@";
				}
			}
			str += "\n";
		}
		System.out.println(str);
		return str;
	}
}
