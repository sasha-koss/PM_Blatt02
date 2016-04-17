package b02.game;

import java.util.List;

public class TTTGame implements Game{
	
	Player pX,pO;
	List<Move> gameMoves;
	
	public TTTGame() {
		// TODO Auto-generated constructor stub
		//gameMoves; // Row,Column Moveset als Move(0,0)... 0,1 0,2 etc
		
	}

	@Override
	public void setPlayerX(Player p) {

		this.pX = p;
	}

	@Override
	public void setPlayerO(Player p) {

		this.pO = p;
	}

	@Override
	public Player currentPlayer() {
		
		// List<Move>.get(IndexofLastMove).getPlayer ? Wenn Playereintrag in Move Klasse.
		return null;
	}

	@Override
	public List<Move> remainingMoves() {

		// Moves mit Player Eintrag?
		return null;
	}

	@Override
	public void doMove(Move m) {
		// Move mit currentPlayer eintrag in List<Move> eintragen?

		
	}

	@Override
	public void undoMove(Move m) {

		// Moves mit Index versehen? somit einfach zu löschen
	}

	@Override
	public boolean ended() {

		// evalState liefert Spielstatus?!
		if(evalState(currentPlayer()) == 0) return false;
		else return true;
	}

	@Override
	public int evalState(Player p) {

		// Gewinnermittlung ist fast fertig, muss diese nur noch an List<Move> anpassen.
		return 0;
	}

	@Override
	public void printField() {

		// List<Move> in for .lenght printen.
		
	}

}
