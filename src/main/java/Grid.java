
public class Grid {
	private final int width = 7;
	private final int height = 6;
	public char[][] grid = new char[height][width];
	
	private static boolean pl1 = true;
	private static boolean pl2 = false;

	// creare la griglia vuota
	
	public void newGrid() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = ' ';
			} 
		}
		System.out.println(grid);
	}
	
	// posizionare la propria "pedina"
	
	public void play(int col) {
		for (int i = height - 1; i >= 0; i--) {
			if (grid[height - 1][col] == ' ') {
				if (pl1) {
					grid[height - 1][col] = 'X';
					Grid.round();
					return;
				} else {
					grid[height - 1][col] = 'O';
					Grid.round();
					return;

			}
			
			}
			
		}
		
	}
	
	// gestire turno dei giocatori 
	
		public static void round() {
			if (pl1) {
				pl1 = false;
				pl2 = true;
			} else {
				pl1 = true;
				pl2 = false;
			}
		}


}
