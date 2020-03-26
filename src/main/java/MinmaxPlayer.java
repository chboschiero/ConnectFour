
public class MinmaxPlayer extends Player {
	private static final int DEFAULT_MAX_DEPTH = 2;
	private int maxDepth;

	MinmaxPlayer(int role) {
		super(role);
		this.maxDepth = DEFAULT_MAX_DEPTH;
	}

	MinmaxPlayer(int role, int maxDepth) {
		super(role);
		this.maxDepth = maxDepth;
	}

	@Override
	int getMove(Board curGrid) {
		int depth = 0;
		int bestCol = -1;
		int maxU = Integer.MIN_VALUE;
		for (int i = 1; i <= Board.getWidth(); i++) {
			Board test = new Board(curGrid.getGrid());
			if (test.checkMove(i)) {
				test.add(i, Player.getMyRole());
				int[] result = this.maximize(test, depth, maxU, i);
				if (result[0] > maxU) {
					maxU = result[1];
					bestCol = result[0];
				}
				
			}
		}
		System.out.println(bestCol);
		return bestCol;
	}

	public int[] maximize(Board curGrid, int depth, int maxU, int col) {
		depth++;
		int curU = Integer.MIN_VALUE;
		String[] wins = curGrid.checkWin();
		if (wins[0] == "true" || depth == maxDepth) {
			curU = this.calculateUtility(curGrid);
			int[] result = { col, curU };
			return result;
		} else {
			for (int i = 1; i <= Board.getWidth(); i++) {
				Board test = new Board(curGrid.getGrid());
				if (test.checkMove(i)) {
					test.add(i, Player.getOtherRole());
					int[] r = this.minimize(test, depth, curU, i);
					if (r[1] > curU) {
						col = r[0];
						curU = r[1];
					}
				}
			}
			int[] result = { col, maxU };
			return result;

		}

	}

	public int[] minimize(Board curGrid, int depth, int maxU, int col) {
		depth++;
		int curU = Integer.MAX_VALUE;
		String[] wins = curGrid.checkWin();
		if (wins[0] == "true" || depth == maxDepth) {
			curU = this.calculateUtility(curGrid);
			int[] result = { col, curU };
			return result;
		} else {
			for (int i = 1; i <= Board.getWidth(); i++) {
				Board test = new Board(curGrid.getGrid());
				if (test.checkMove(i)) {
					test.add(i, Player.getMyRole());
					int[] r = this.maximize(test, depth, curU, i);
					if (r[1] < curU) {
						col = r[0];
						curU = r[1]; //prima era maxU
					}
				}
			}
			int[] result = { col, maxU };
			return result;
		}
	}

	public int calculateUtility(Board curGrid) {
		String[] wins = curGrid.checkWin();
		if (wins[0] == "true") {
			if (wins[1] == "X" && Player.getMyRole() == 1) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}
}
