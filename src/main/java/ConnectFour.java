import java.util.Random;

public class ConnectFour {
	public static void main(String[] args) {
		Board board = new Board();
		Player player = new Player();
		System.out.println("Let's play! Choose a column from 1 to 7");
		System.out.println();
		board.newGrid();
		
		while (!Board.isWin() && turn < Board.getWidth() * Board.getHeight() + 1) {
			System.out.println("Player " + Board.getPlayer() + ", it's your turn:");
			int col = player.getMove(board);
			board.add(col, Board.getPlayer());
			board.visualize();
			String[] wins = board.checkWin();
			if (wins[0] == "true") {
				board.win(Board.getPlayer());
			} else {
				turn++;
				System.out.println();
				if (turn < Board.getWidth() * Board.getHeight() + 1) {
					board.flipPlayer(Board.getPlayer());
				}
			}
		}
		if (!Board.isWin()) {
			System.out.println("Game over! No one wins. Try again.");
		}
	}

	static int turn = 1;
}
