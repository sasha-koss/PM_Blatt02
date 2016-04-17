package b02.game;

import b02.strategy.*;

public class Main {

	public static void main(String[] args) {
		Game g = new TTTGame();
		Player pO = new TTTPlayer('O');
		Player pX = new TTTPlayer('X');
		GameStrategy gs = new TTTGameStrategy();
		pO.setStrategy(gs);
		pX.setStrategy(gs);
		g.setPlayerO(pO);
		g.setPlayerX(pX);
		do{
			g.printField();
			g.doMove(gs.nextMove(g));
		}while(!g.ended());
	}

}
