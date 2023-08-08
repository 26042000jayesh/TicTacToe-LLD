package TicTacToe;

import java.util.Scanner;

public class Board {
	final private int boardDimension;
	final private Symbol board[][];
	Scanner scn = new Scanner(System.in);

	public Board(int boardDimension) {
		super();
		this.boardDimension = boardDimension;
		this.board = new Symbol[boardDimension][boardDimension];
		initializeBoard();
	}

	public Symbol[][] getBoard() {
		return board;
	}

	public int getBoardDimension() {
		return boardDimension;
	}

	public void initializeBoard() {
		for (int i = 0; i < boardDimension; i++) {
			for (int j = 0; j < boardDimension; j++) {
				board[i][j] = Symbol.B;
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < boardDimension; i++) {
			for (int j = 0; j < boardDimension; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isValidChoice(int choice) {
		int row = choice / boardDimension;
		int col = choice % boardDimension;
		return row >= 0 && row < boardDimension && col >= 0 && col < boardDimension
				&& board[row][col] == Symbol.B;
	}

	public int makeChoice(Player currentPlayer) {
		System.out.println(currentPlayer.getUserName() + " choose a number between 0 and "
				+ (boardDimension * boardDimension - 1));

		int choice = scn.nextInt();
		return choice;
	}

	public void doChangesOnBoard(int choice, Player currentPlayer) {
		int row = choice / boardDimension;
		int col = choice % boardDimension;
		board[row][col] = currentPlayer.getSymbol();
	}

	public boolean checkIfWon(Player currentPlayer, int choice) {
		int row = choice / boardDimension;
		int col = choice % boardDimension;
		boolean rowWon = true, colWon = true;
		for (int i = 0; i < boardDimension; i++) {
			rowWon = rowWon && board[i][col] == currentPlayer.getSymbol();
		}
		for (int i = 0; i < boardDimension; i++) {
			colWon = colWon && board[row][i] == currentPlayer.getSymbol();
		}
		if (row == col) {
			boolean diagonalWon = true;
			for (int i = 0; i < boardDimension; i++) {
				diagonalWon = diagonalWon && board[i][i] == currentPlayer.getSymbol();
			}
			if (diagonalWon) {
				return diagonalWon;
			}
		}
		if (row + col == boardDimension - 1) {
			boolean reverseDiagonalWon = true;
			for (int i = 0; i < boardDimension; i++) {
				reverseDiagonalWon = reverseDiagonalWon
						&& board[boardDimension - 1 - i][i] == currentPlayer.getSymbol();
			}
			if (reverseDiagonalWon) {
				return reverseDiagonalWon;
			}
		}
		return rowWon || colWon;
	}
}
