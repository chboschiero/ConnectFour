
public class Board extends ConnectFour {

	static char[][] grid = new char[Board.getHeight()][Board.getWidth()];
	private static final int width = 7;
	private static final int height = 6;

	private static int lastRow = 0;
	private static int lastCol = 0;

	private static boolean win = false; // finché è false si può continuare a giocare
	private static int player = 1;

// visualizzare la griglia iniziale

	public void newGrid() {
		for (int col = 0; col < getWidth(); col++) {
			System.out.print(col + 1);
		}
		System.out.println();
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				grid[i][j] = '.';
				System.out.print(grid[i][j]);
			}
			System.out.println();

		}
		System.out.println();
	}

// visualizzare la nuova griglia dopo ogni mossa

	public void visualize() {
		for (int col = 0; col < getWidth(); col++) {
			System.out.print(col + 1);
		}
		System.out.println();
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();

		}
	}

// posizionare la propria "pedina" e memorizzare ultima mossa

	public void add(int col, int player) {
		for (int i = getHeight() - 1; i >= 0; i--) {
			if (grid[i][col - 1] == '.') {
				if (player == 1) {
					grid[i][col - 1] = 'X';
				} else if (player == 2) {
					grid[i][col - 1] = 'O';
				}
				lastRow = i;
				lastCol = col - 1;
				return;

			}

		}
	}

// stabilire se la giocata è consentita (colonna esistente e non piena)

	public boolean checkMove(int col) {
		if (col < 1 || col > getWidth()) {
			System.out.println("Bad input: choose a column from 1 to 7");
			return false;
		}
		if (grid[0][col - 1] != '.') {
			System.out.println("Full column! Try another one");
			return false;
		}
		return true;
	}
	
// stabilire chi sta vincendo
	
	public String[] whoWinning(Board curGrid) {
		String[] winner = new String[2];
		boolean win = curGrid.checkWin(Board.getLastRow(), Board.getLastCol(), Board.getGrid());
		if (win) {
			winner[0] = "true";
		} else {
			winner[0] = "false";
		}
		if (Board.getPlayer() == 1) {
			winner[1] = "X";
		} else {
			winner[1] = "O";
		}
		
		// chiamare checkWin (che sarà un booleano) 
		return winner;
		
	}

// stabilire se l'ultima mossa è vincente

	public boolean checkWin(int row, int col, char[][] curGrid) {
		// verticale
		if (row <= 2) {
			if (curGrid[row][col] == curGrid[row + 1][col] && curGrid[row][col] == curGrid[row + 2][col]
					&& curGrid[row][col] == curGrid[row + 3][col]) {
				System.out.println();
				System.out.println("Vertical win on column " + (col + 1));
				return true;
			}

		}
		// orizzontale
		col = 0;
		char cur = curGrid[row][col];
		int connect = 1;
		for (int i = 0; i < Board.getWidth() - 1; i++) {
			if (cur == curGrid[row][col + 1] && cur != '.') {
				cur = curGrid[row][col + 1];
				connect++;
				col++;
			} else {
				cur = curGrid[row][col + 1];
				connect = 1;
				col++;
			}
			if (connect == 4) {
				System.out.println();
				System.out.println("Horizontal win on row " + (row + 1));
				return true;
			}

		}
		// diagonale
		return false;

	}

// stabilire chi ha vinto (si chiamerà  alla fine del metodo che rileva un Forza4)

	public void win(int player) {
		if (player == 1) {
			System.out.println();
			System.out.println("Well done, Player 1!");
			Board.setWin(true);
		} else if (player == 2) {
			System.out.println();
			System.out.println("Well done, Player 2!");
			Board.setWin(true);
		}
	}

// gestire turno dei giocatori 

	public void flipPlayer(int player) {
		if (player == 1) {
			setPlayer(2);
		} else {
			setPlayer(1);
		}
	}

	
	
// getter and setter

	public static int getHeight() {
		return height;
	}

	public static int getWidth() {
		return width;
	}

	public static int getPlayer() {
		return player;
	}

	public static void setPlayer(int player) {
		Board.player = player;
	}

	public static boolean isWin() {
		return win;
	}

	public static void setWin(boolean win) {
		Board.win = win;
	}

	public static int getLastRow() {
		return lastRow;
	}

	public static void setLastRow(int lastRow) {
		Board.lastRow = lastRow;
	}

	public static int getLastCol() {
		return lastCol;
	}

	public static void setLastCol(int lastCol) {
		Board.lastCol = lastCol;
	}

	public static char[][] getGrid() {
		return grid;
	}

	public static void setGrid(char[][] grid) {
		Board.grid = grid;
	}

}
