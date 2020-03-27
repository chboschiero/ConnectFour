import java.util.Random;

public class MinmaxPlayer extends Player {
	private static final int DEFAULT_MAX_DEPTH = 6;
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
		float depth = 0;
		int turn = Board.getTurn();
		int bestCol = -1;
		float maxU = Integer.MIN_VALUE;
		for (int i = 1; i <= Board.getWidth(); i++) {
			Board test = new Board(curGrid.getGrid());
			if (test.checkMove(i)) {
				test.add(i, Player.getMyRole());
				float result = this.minimize(test, depth, turn);
				if (result > maxU) {
					bestCol = i;
					maxU = result;
				} 
			}
		}
		System.out.println(bestCol);
		return bestCol;
	}

	public float maximize(Board curGrid, float depth, int turn) {
		turn ++;
		depth++;
		float maxU = Integer.MIN_VALUE;
		String[] wins = curGrid.checkWin();
		if (wins[0] == "true" || depth == maxDepth || turn == Board.getMaxMoves()) {
			maxU = this.calculateUtility(curGrid, depth);
			return maxU;
		} else {
			for (int i = 1; i <= Board.getWidth(); i++) {
				Board test = new Board(curGrid.getGrid());
				if (test.checkMove(i)) {
					test.add(i, Player.getMyRole());
					float r = this.minimize(test, depth, turn);
					if (r > maxU) {
						maxU = r;
					}
				}
			}
			return maxU;

		}

	}

	public float minimize(Board curGrid, float depth, int turn) {
		turn++;
		depth++;
		float minU = Integer.MAX_VALUE;
		String[] wins = curGrid.checkWin();
		if (wins[0] == "true" || depth == maxDepth || turn == Board.getMaxMoves()) {
			minU = this.calculateUtility(curGrid, depth);
			return minU;
		} else {
			for (int i = 1; i <= Board.getWidth(); i++) {
				Board test = new Board(curGrid.getGrid());
				if (test.checkMove(i)) {
					test.add(i, Player.getOtherRole());
					float r = this.maximize(test, depth, turn);
					if (r < minU) {
						minU = r;
					}
				}
			}
	
			return minU;
		}
	}

	public float calculateUtility(Board curGrid, float depth) {
		String[] wins = curGrid.checkWin();
		if (wins[0] == "true") {
			if (wins[1] == "X" && Player.getMyRole() == 1) {
				return 1/depth;
			} else if (wins[1] == "O" && Player.getMyRole() == 2) {
				return 1/depth;
			} else {
				return -1/depth;
			}
		}
		return 0;
	}
}
