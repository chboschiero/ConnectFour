import java.util.Scanner;

public class ConnectFour {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Board board = new Board();
			
			System.out.print("Who's Player 1? ");
			String s1 = scanner.nextLine();
			Player player1 = null;
			if (s1.contentEquals("human")) {
				player1 = new Human();
			} else if (s1.contentEquals("dummy")) {
				player1 = new Dummy();
			}
			System.out.print("Who's Player 2? ");
			String s2 = scanner.nextLine();
			Player player2 = null;
			if (s2.contentEquals("human")) {
				player2 = new Human();
			}	else if (s2.contentEquals("dummy")) {
				player2 = new Dummy();
			}
			
			System.out.println();
			System.out.println("Let's play! Choose a column from 1 to 7");
			System.out.println();
			board.newGrid();
			
			while (!Board.isWin() && turn < Board.getWidth() * Board.getHeight() + 1) {
				System.out.println("Player " + Board.getPlayer() + ", it's your turn:");
				int col = -1;
				if (Board.getPlayer() == 1) {
					col = player1.getMove(board);
				} else {
					col = player2.getMove(board);
				}
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
		}
		if (!Board.isWin()) {
			System.out.println("Game over! No one wins. Try again.");
		}
	}

	static int turn = 1;
}
