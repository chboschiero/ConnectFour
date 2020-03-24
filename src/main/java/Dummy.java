import java.util.Random;

public class Dummy extends Player {

	Dummy(int role) {
		super(role);
	}

	@Override
	public int getMove(Board curGrid) {
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
