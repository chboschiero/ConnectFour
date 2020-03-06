import java.util.Scanner;


public class ConnectFour {
	public static void main(String[] args) {
		
		
		Board board = new Board();
		board.newGrid();
		board.add(5, player);
		board.visualize();
		board.flipPlayer(player);
		board.add(5, player);
		board.visualize();

				
	}

	public static int player = 1;

}
