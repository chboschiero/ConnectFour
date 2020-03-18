import java.util.Random;
import java.util.Scanner;

public class Player extends ConnectFour {

// mossa del giocatore

	public int getMove(Board curGrid) {
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);
		int col = -1;
		while (!flag) {
			col = scanner.nextInt();
			flag = curGrid.checkMove(col);
		}
		return col;
	}
	
	public int getMoveRnd(Board curGrid) {
		Random rnd = new Random();
		int col = rnd.nextInt(7);
		return col;
	}
	
	
	
//	public int getMove2(Board curGrid) {
//	Scanner scanner = new Scanner(System.in);
//	int col = scanner.nextInt();
//	if (curGrid.checkMove(col)) {
//		return col;
//	}
//
//	return 0;
//}
}
