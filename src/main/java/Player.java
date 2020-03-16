import java.util.Scanner;

public class Player extends ConnectFour {

// mossa del giocatore

//	public int getMove2(Board curGrid) {
//		Scanner scanner = new Scanner(System.in);
//		int col = scanner.nextInt();
//		if (curGrid.checkMove(col)) {
//			return col;
//		}
//
//		return 0;
//	}

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

}
