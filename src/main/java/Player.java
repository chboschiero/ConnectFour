
abstract class Player {

	private static int myRole;
	private static int otherRole;
	
	Player(int role) {
		if (role == 1) {
			myRole = 1;
			otherRole = 2;
		} else {
			myRole = 2;
			otherRole = 1;
		}
	}
	
	public static int getMyRole() {
		return myRole;
	}
	public static int getOtherRole() {
		return otherRole;
	}

// mossa del giocatore

	abstract int getMove(Board curGrid);
	

}
