import java.util.Scanner;

public class ConnectFour {
	public static void main(String[] args) {
		Board board = new Board();
		Player player = new Player();
		System.out.println("Let's play! Choose a column from 1 to 7");
		System.out.println();
		board.newGrid();
		
		System.out.println("Player " + Board.getPlayer() + ", it's your turn:");
		while (!Board.isWin() && turn < Board.getWidth() * Board.getHeight() + 1) {
			int col = player.getMove(board);
			if (col != 0) {
				board.add(col, Board.getPlayer());
				board.visualize();
				String[] wins = board.whoWinning(board);
				if (wins[0] == "true") {
					board.win(Board.getPlayer());
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

		if (!Board.isWin()) {
			System.out.println("Game over! No one wins. Try again.");
		}
	}

	static int turn = 1;

}
