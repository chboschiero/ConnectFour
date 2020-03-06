
public class Player {
	private static boolean win = true; // finché è true si può continuare a giocare
	private static boolean pl1 = true;
	private static boolean pl2 = false;
	

		
// stabilire chi ha vinto (si chiamerà alla fine del metodo che rileva un Forza4)
	
	public void win(int player) {
		if (player == 1) {
			System.out.println("Well done, Player 1!");
			win = false;
		} else if (player == 2) {
			System.out.println("Well done, Player 2!");
			win = false;
		}
	}

}
