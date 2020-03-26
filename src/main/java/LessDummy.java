import java.util.Random;

public class LessDummy extends Player {

	LessDummy(int role) {
		super(role);
	}

	@Override
	public int getMove(Board curGrid) {
		for (int i = 1; i <= Board.getWidth(); i++) {			
			Board test = new Board(curGrid.getGrid());
			if (test.checkMove(i)) {
				test.add(i, Player.getMyRole());
				String[] wins = test.checkWin();
				if (wins[0] == "true") {
					System.out.println(i);
					return i;
				}

			}
		}
		for (int i = 1; i <= Board.getWidth(); i++) {
			Board test = new Board(curGrid.getGrid());
			if (test.checkMove(i)) {
				test.add(i, Player.getOtherRole());
				String[] wins = test.checkWin();
				if (wins[0] == "true") {
					System.out.println(i);
					return i;
				}

			}
		}
		boolean flag = false;
		Random rnd = new Random();
		int col = -1;
		while (!flag) {
			col = rnd.nextInt(7) + 1;
			flag = curGrid.checkMove(col);
		}
		System.out.println(col);
		return col;

	}

}
