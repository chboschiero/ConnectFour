import java.util.Scanner;


public class ConnectFour {
	public static void main(String[] args) {	
		Board board = new Board();
		Player p = new Player();
		System.out.println("Let's play! Choose a column from 1 to 7");
		System.out.println();
		board.newGrid();
		Scanner scanner = new Scanner(System.in);
		
		while (!win && turn < width * height) {
       		int col = scanner.nextInt();
    		if (board.validatePlay(col)) {
    			board.add(col, player);
    	    	board.visualize();
    	   		board.flipPlayer(player);
    	   		if (win) {
    	   			
    	   			p.win(player);
    	   		} else {
    	   			turn++;
    	   			System.out.println();
    	   	   		System.out.println("Player " + player + ", it's your turn:");
    	   		}
    		}
    	}
    		
		
       	
    }

	static int turn = 1; 	
	protected static boolean win = false; // finché è false si può continuare a giocare					
	protected static int player = 1;
	protected static final int width = 7;
	protected static final int height = 6;
	

	
}

