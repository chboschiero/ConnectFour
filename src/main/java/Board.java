
public class Board extends ConnectFour {
	private static final int width = 7;
	private static final int height = 6;
	private char[][] board = new char[height][width];
	private static final int maxMoves = height * width;
	
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
	}
	
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
	
	// gestire turno dei giocatori 
	
	public void flipPlayer(int player) {
		if (player == 1) {
			super.player = 2;
		} else {
			super.player = 1;
		}
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}


}
