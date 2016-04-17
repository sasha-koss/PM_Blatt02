package b02.game;

public class TTTMove implements Move {
	
	int row,column;
	public TTTMove(int pRow, int pColumn) {
		// TODO Auto-generated constructor stub
		this.row = pRow;
		this.column = pColumn;
	}

	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return this.row;
	}

	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return this.column;
	}
}
