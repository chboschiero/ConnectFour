import java.util.Scanner;

public class Human extends Player {
	
	
	Human(int role) {
		super(role);
	}

	@Override
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
