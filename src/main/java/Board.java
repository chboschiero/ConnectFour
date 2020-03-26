import java.util.ArrayList;
import java.util.List;

public class Board {

	private String[][] grid = new String[Board.getHeight()][Board.getWidth()];
	private static final int width = 7;
	private static final int height = 6;
	private static final int maxMoves = height * width;
	static int turn = 1;

	private static int player = 1;
	private static boolean win = false; // finché è false si può continuare a giocare

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
			if (grid[i][col - 1] == ".") { // grid è un attributo della classe
				if (player == 1) {
					grid[i][col - 1] = "X";
				} else if (player == 2) {
					grid[i][col - 1] = "O";
				}
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
		if (grid[0][col - 1] != ".") {
//			System.out.println("Full column! Try another one");
			return false;
		}
		return true;
	}

// check del connect sul vettore creato

	private String[] evaluateArray(String[] array) {
		String[] s = { "false", "." };
		if (array.length <= 3) {
			return s;
		}
		String tmp_element = array[0];
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

// stabilire se l'ultima mossa è vincente

	public String[] checkWin() {
		// orizzontale
		String[] arrayH = new String[Board.getWidth()];
		for (int i = 0; i < Board.getHeight(); i++) {
			for (int j = 0; j < arrayH.length; j++) {
				arrayH[j] = grid[i][j];
			}
			String[] win = this.evaluateArray(arrayH);
			if (win[0] == "true") {
//				System.out.println("Horizontal win");
				return win;
			}
		}
		// verticale
		String[] arrayV = new String[Board.getHeight()];
		for (int i = 0; i < Board.getWidth(); i++) {
			for (int j = 0; j < arrayV.length; j++) {
				arrayV[j] = grid[j][i];
			}
			String[] win = this.evaluateArray(arrayV);
			if (win[0] == "true") {
//				System.out.println("Vertical win");
				return win;
			}
		}
		// diagonale backslash
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
//				System.out.println("Diagonal win");
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
//				System.out.println("Diagonal win");
				return win;

			}

		}
		// diagonale slash
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
//				System.out.println("Diagonal win");
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
//				System.out.println("Diagonal win");
				return win;
			}
		}

		String[] noWin = { "false", "." };
		return noWin;

	}

// stabilire chi ha vinto (si chiamerà alla fine del metodo che rileva un Forza4)

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

// Constructor
	
	Board() {
	}

	public Board(String[][] curGrid) {
		for (int i = 0; i < Board.getHeight(); i++) {
			for (int j = 0; j < Board.getWidth(); j++) {
				grid[i][j] = curGrid[i][j];
			}
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

	public String[][] getGrid() {
		return this.grid;
	}

	public void setGrid(String[][] grid) {
		this.grid = grid;
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

	public static int getMaxmoves() {
		return maxMoves;
	}
	

}



