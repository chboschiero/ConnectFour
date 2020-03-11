import java.util.Scanner;

public class Player extends ConnectFour {
	
// mossa del giocatore
	
	public int getMove(Board curGrid) {
		Scanner scanner = new Scanner(System.in);
			int col = scanner.nextInt() ;
			if(curGrid.checkMove(col)) {
				return col;
			}
		return 0;
		}
	
	
	
}
