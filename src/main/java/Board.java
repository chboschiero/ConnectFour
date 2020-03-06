
public class Board extends ConnectFour {
	
	
	private char[][] board = new char[height][width];
	
	private static boolean pl1 = true;
	private static boolean pl2 = false;
	
	private int player = 1;

	// visualizzare la griglia 
	
	public void newGrid() {
		for (int col = 0; col < width; col++) {
        	System.out.print(col+1);
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
     		for (int j = 0; j < width; j++) {
     			board[i][j] = '.' ;
     			System.out.print(board[i][j]);
			} 
     		System.out.println();
			
		}
        System.out.println();
        System.out.println("Player " + player + ", it's your turn:");
	}
	
	// visualizzare la nuova griglia dopo ogni mossa
	
	public void visualize() {
		System.out.println();
		for (int col = 0; col < width; col++) {
        	System.out.print(col+1);
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
     		for (int j = 0; j < width; j++) {
     			System.out.print(board[i][j]);
			} 
     		System.out.println();
			
		}
	}

	// posizionare la propria "pedina"
	
	public void add(int col, int player) {
			for (int i = height - 1; i >= 0; i--) {
			if (board[i][col-1] == '.') {
				if (player == 1) {
					board[i][col-1] = 'X';
					return;
				} else if (player == 2){
					board[i][col-1] = 'O';
					return;
				}
			
			}
			
		}	
	}
	
// stabilire se la giocata è consentita (colonna esistente e non piena)
	
	public boolean validatePlay(int col) {
		if (col < 1 || col > width) {				
			System.out.println("Bad input: choose another column");
			return false;
		} 
		if (board[0][col - 1] == 'X' || board[0][col - 1] == 'O' ) {
			System.out.println("Full column! Try another one");
			return false;
		} 
		return true;
	}

	
	// gestire turno dei giocatori 
	
	public void flipPlayer(int player) {
		if (player == 1) {
			super.player = 2;
		} else {
			super.player = 1;
		}
	}


}
