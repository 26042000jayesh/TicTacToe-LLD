package TicTacToe;

public class Game {
	private int movesLeft;
	private final int numberOfPlayers, boardDimension;
	private final Player players[];
	private final Board board;
	private int turn = 0;
	private GameStatus gameStatus = GameStatus.ONGOING;

	public Game(int numberOfPlayers, Player[] players, int boardDimension) {
		super();
		this.numberOfPlayers = numberOfPlayers;
		this.players = players;
		this.boardDimension = boardDimension;
		this.board = new Board(boardDimension);
		movesLeft = this.boardDimension * this.boardDimension;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}


	private void changeTurn() {
		turn = (turn + 1) % numberOfPlayers;
		movesLeft--;
	}

	public void play() {
		board.printBoard();
		int choice = board.makeChoice(players[turn]);
		while (board.isValidChoice(choice) == false) {
			System.out.println("Incorrect choice");
			choice = board.makeChoice(players[turn]);
		}
		board.doChangesOnBoard(choice, players[turn]);
		if (board.checkIfWon(players[turn], choice) == true) {
			gameStatus = GameStatus.WIN;
			announceWinner();
			return;
		}
		changeTurn();
		if (movesLeft == 0) {
			gameStatus = GameStatus.DRAW;
			announceDraw();
		}
	}
	
	private void announceWinner() {
		System.out.println(players[turn].getUserName()+" won\n");
		board.printBoard();
	}
	
	private void announceDraw() {
		System.out.println("Game draw");
	}
}
