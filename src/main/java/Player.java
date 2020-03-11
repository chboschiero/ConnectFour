
public class Player extends ConnectFour {
	

// stabilire se l'ultima mossa è vincente
	
	public void checkWin(int row, int col, char[][] curGrid) {
		// verticale
		if (row <= 2) { 
			if (curGrid[row][col] == curGrid[row +1][col] && curGrid[row][col] == curGrid[row + 2][col] && curGrid[row][col] == curGrid[row + 3][col]) {
				Board.setWin(true);
				System.out.println("Vertical win on column " + (col + 1));
				return;
			}
			
		}
		// orizzontale
		col = 0;
		char cur = curGrid[row][col];
		int connect = 1;
		for (int i = 0; i < Board.getWidth() - 1 ; i++) {
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
				Board.setWin(true);
				System.out.println("Horizontal win on row " + (row + 1));
				return;
			}
			
		}
		// diagonale
		
		
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

	
}
