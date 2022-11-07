package thePackage;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board1 = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		char[][] board2 = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		
		printBoard(board1);
		printBoard(board2);
	}
	
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public boolean isValidSudoku(char[][] board) {
		if (checkRows(board)) {
			System.out.println("rows valid");
			if (checkColumns(board)) {
				System.out.println("columns valid");
				if (checkBoxes(board)) {
					System.out.println("3x3 boxes valid");
					return true;
				}
			}
		}

		return false;
	}

	public boolean checkRows(char[][] board) {
		/* go through and check each row */
		for (int i = 0; i < board.length; i++) {
			/* check each individual row */
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					for (int k = j + 1; k < board[i].length; k++) {
						if (board[i][j] == board[i][k])
							return false;
					}
				}
			}
		}
		return true;
	}

	public boolean checkColumns(char[][] board) {
		/* go through and check each column */
		for (int i = 0; i < board.length; i++) {
			/* check each individual column */
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					for (int k = i + 1; k < board[i].length; k++) {
						if (board[i][j] == board[k][j])
							return false;
					}
				}
			}
		}
		return true;
	}

	public boolean checkBoxes(char[][] board) {
		char[][] temp = new char[3][3];
		for (int boxRow = 0; boxRow < 3; boxRow++) {
			for (int colRow = 0; colRow < 3; colRow++) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						temp[i][j] = board[i + (3 * boxRow)][j + (3 * colRow)];
					}
				}
				if (!checkBox(temp))
					return false;
			}
		}
		return true;
	}

	public boolean checkBox(char[][] box) {
		char temp;
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				temp = box[a][b];
				if (temp != '.') {
					int i = a;
					for (int j = b + 1; j < 3; j++) {
						if (temp == box[i][j]) {
							return false;
						}
					}
					for (i = a + 1; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (temp == box[i][j]) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

//	public boolean checkBox(char[][] box) {
//		char temp;
//		for (int num = 0; num < 9; num++) {
//			temp = box[num / 3][num % 3];
//			/* check by row */
//			for (int i = num / 3; i < 3; i++) {
//				/* check the first row, which may only be partial */
//				if (i == num / 3) {
//					if (num % 3 == 0) {
//						for (int j = 1; j < 3; j++) {
//							if (temp == box[i][j])
//								return false;
//						}
//					} else if (num % 3 == 1) {
//						if (temp == box[i][2])
//							return false;
//					} else if (num % 3 == 2) {
//
//					}
//				} else /* check the next rows, which will be full */ {
//					for (int j = 0; j < 3; j++) {
//						if (temp == box[i][j])
//							return false;
//					}
//				}
//			}
//		}
//		return true;
//	}
}
