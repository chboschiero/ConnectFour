import java.util.Scanner;


public class ConnectFour {
	public static void main(String[] args) {	
		Board board = new Board();
		Player move = new Player();
		System.out.println("Let's play! Choose a column from 1 to 7");
		System.out.println();
		board.newGrid();
		try (Scanner scanner = new Scanner(System.in)) {
			while (!Board.isWin() && turn < Board.getWidth() * Board.getHeight() + 1) {
				int col = scanner.nextInt();
				if (board.checkMove(col)) {
					board.add(col, Board.getPlayer());
					if (turn >= 7) {
						move.checkWin(Board.getLastRow(), Board.getLastCol(), Board.getGrid());
					}
			    	board.visualize();
			   		if (Board.isWin()) {
			   			move.win(Board.getPlayer());
			   		} else {
			   			turn++;
			   			System.out.println();
			   			if (turn < Board.getWidth() * Board.getHeight() + 1) {
			   				board.flipPlayer(Board.getPlayer());
			   				System.out.println("Player " + Board.getPlayer() + ", it's your turn:");
			   			}	
			   		}
				}
			}
		}
		if (!Board.isWin()) {
			System.out.println("Game over! No one wins. Try again.");
		} 	
    }

	static int turn = 1;
		
}

