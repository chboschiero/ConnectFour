import java.util.ArrayList;
import java.util.List;

public class Board extends ConnectFour {

	static String[][] grid = new String[Board.getHeight()][Board.getWidth()];
	private static final int width = 7;
	private static final int height = 6;
	static int turn = 1;

	private static int lastRow = 0;
	private static int lastCol = 0;

	private static int player = 1;
	private static boolean win = false; // finch� � false si pu� continuare a giocare

// visualizzare la griglia iniziale

	public void newGrid() {
		for (int col = 0; col < getWidth(); col++) {
			System.out.print(col + 1);
		}
		System.out.println();
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				grid[i][j] = ".";
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
			if (grid[i][col - 1] == ".") { // grid � un attributo della classe
				if (player == 1) {
					grid[i][col - 1] = "X";
				} else if (player == 2) {
					grid[i][col - 1] = "O";
				}
				lastRow = i;
				lastCol = col - 1;
				return;

			}

		}
	}

// stabilire se la giocata � consentita (colonna esistente e non piena)

	public boolean checkMove(int col) {
		if (col < 1 || col > getWidth()) {
			System.out.println("Bad input: choose a column from 1 to 7");
			return false;
		}
		if (grid[0][col - 1] != ".") {
			System.out.println("Full column! Try another one");
			return false;
		}
		return true;
	}

// check della 

	private String[] evaluateArray(String[] array) {
		String[] s = { "false", "." };
		if (array.length <= 3) {
			return s;
		}
		String tmp_element = array[0]; // istanziare array
		int connect = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == tmp_element && tmp_element != ".") {
				connect++;
			} else {
				tmp_element = array[i];
				connect = 1;
			}
			if (connect == 4) {
				s[0] = "true";
				s[1] = tmp_element;
				return s;
			}
		}
		return s;
	}

// stabilire se l'ultima mossa � vincente

	public String[] checkWin() {
		String[] arrayH = new String[Board.getWidth()];
		for (int i = 0; i < Board.getHeight(); i++) {
			for (int j = 0; j < arrayH.length; j++) {
				arrayH[j] = grid[i][j];
			}
			String[] win = this.evaluateArray(arrayH);
			if (win[0] == "true") {
				System.out.println("Horizontal win");
				return win;
			}
		}
		String[] arrayV = new String[Board.getHeight()];
		for (int i = 0; i < Board.getWidth(); i++) {
			for (int j = 0; j < arrayV.length; j++) {
				arrayV[j] = grid[j][i];
			}
			String[] win = this.evaluateArray(arrayV);
			if (win[0] == "true") {
				System.out.println("Vertical win");
				return win;
			}
		}
		
		
		for (int i = 0; i < Board.getHeight(); i++) {
			List<String> candidate = new ArrayList<>();
			int row = i;
			int col = 0;
			while (row <= 5 && col <= 6) {
				candidate.add(grid[row][col]);
				row++;
				col++;
			}
			String[] arrayBs = new String[candidate.size()];
			String[] win = this.evaluateArray(candidate.toArray(arrayBs));
			if (win[0] == "true") {
				System.out.println("Diagonal win");
				return win;

			}
			
		}
		for (int i = 1; i < Board.getWidth(); i++) {
			List<String> candidate = new ArrayList<>();
			int row = 0;
			int col = i;
			while (row <= 5 && col <= 6) {
				candidate.add(grid[row][col]);
				row++;
				col++;
			}
			String[] arrayBs = new String[candidate.size()];
			String[] win = this.evaluateArray(candidate.toArray(arrayBs));
			if (win[0] == "true") {
				System.out.println("Diagonal win");
				return win;

			}

		}
		for (int i = Board.getHeight() - 1; i >= 0; i--) {
			List<String> candidate = new ArrayList<>();
			int row = i;
			int col = 0;
			while (row >= 0 && col <= 6) {
				candidate.add(grid[row][col]);
				row--;
				col++;
			}
			String[] arrayS = new String[candidate.size()];
			String[] win = this.evaluateArray(candidate.toArray(arrayS));
			if (win[0] == "true") {
				System.out.println("Diagonal win");
				return win;
			}
		}
		
		for (int i = 1; i < Board.getWidth(); i++) {
			List<String> candidate = new ArrayList<>();
			int row = Board.getHeight() - 1;
			int col = i;
			while (row >= 0 && col <= 6) {
				candidate.add(grid[row][col]);
				row--;
				col++;
			}
			String[] arrayS = new String[candidate.size()];
			String[] win = this.evaluateArray(candidate.toArray(arrayS));
			if (win[0] == "true") {
				System.out.println("Diagonal win");
				return win;
			}
		}

		arrayV[0] = "false";
		return arrayV;

	}
//		for (ciclo nelle colonne) {
//			costruire il String[] della colonna
//			passare il String[] della colonna al metodo private 
//			se restituisce una win situation restituire la stringa[]
//					if (s[0] == "true") {
//						return s;
//					}
//		}

//	public boolean checkWin2(int row, int col) {
//		// verticale
//		if (row <= 2) {
//			if (grid[row][col] == grid[row + 1][col] && grid[row][col] == grid[row + 2][col]
//					&& grid[row][col] == grid[row + 3][col]) {
//				System.out.println();
//				System.out.println("Vertical win on column " + (col + 1));
//				return true;
//			}
//
//		}
//		// orizzontale
//		col = 0;
//		String cur = grid[row][col];
//		int connect = 1;
//		for (int i = 0; i < Board.getWidth() - 1; i++) {
//			if (cur == grid[row][col + 1] && cur != ".") {
//				cur = grid[row][col + 1];
//				connect++;
//				col++;
//			} else {
//				cur = grid[row][col + 1];
//				connect = 1;
//				col++;
//			}
//			if (connect == 4) {
//				System.out.println();
//				System.out.println("Horizontal win on row " + (row + 1));
//				return true;
//			}
//
//		}
//		// diagonale
//		return false;

// stabilire chi ha vinto (si chiamer� alla fine del metodo che rileva un Forza4)

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

	public static String[][] getGrid() {
		return grid;
	}

	public static void setGrid(String[][] grid) {
		Board.grid = grid;
	}

	public static boolean isWin() {
		return win;
	}

	public static void setWin(boolean win) {
		Board.win = win;
	}

	public static void setTurn(int turn) {
		Board.turn = turn;
	}

	public static int getTurn() {
		return turn;
	}
}
