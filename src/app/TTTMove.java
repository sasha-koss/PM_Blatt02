package app;

import b02.game.Move;

public class TTTMove implements Move {
	
	int row,column;
	public TTTMove(int pRow, int pColumn) {
		this.row = pRow;
		this.column = pColumn;
	}

	@Override
	public int getRow() {
		return this.row;
	}

	@Override
	public int getColumn() {
		return this.column;
	}
}
