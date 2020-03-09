
public class Player extends ConnectFour {
	
	
	

// stabilire se l'ultima mossa è vincente
	

	public void checkWinVertical(int row, int col, char[][] curGrid) {
		if (row <= 2) {
			if (curGrid[row][col] == curGrid[row +1][col] && curGrid[row][col] == curGrid[row + 2][col] && curGrid[row][col] == curGrid[row + 3][col]) {
				Board.setWin(true);
				System.out.println("Vertical win on column " + (col + 1));
			}
			
		}

	}
	
// stabilire chi ha vinto (si chiamerà alla fine del metodo che rileva un Forza4)
	
	public void win(int player) {
		if (player == 1) {
			System.out.println();
			System.out.println("Well done, Player 1!");
			Board.setWin(false);
		} else if (player == 2) {
			System.out.println();
			System.out.println("Well done, Player 2!");
			Board.setWin(false);
		}
	}

	
}
