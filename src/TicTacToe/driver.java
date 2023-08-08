package TicTacToe;

public class driver {
	public static void main(String[] args) {
		
		Player players[] = new Player[2];
		players[0]=new Player("Jayesh", Symbol.O);
		players[1] = new Player("Yogesh", Symbol.X);
		Game g1=new Game(2,players , 3);
		while (g1.getGameStatus()==GameStatus.ONGOING) {
			g1.play();
		}
	}
}
