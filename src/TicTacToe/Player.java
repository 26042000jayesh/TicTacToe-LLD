package TicTacToe;

public class Player extends User {
	private final Symbol symbol;

	public Player(String userName, Symbol symbol) {
		super(userName);
		this.symbol = symbol;
	}

	public Symbol getSymbol() {
		return symbol;
	}
	

}
