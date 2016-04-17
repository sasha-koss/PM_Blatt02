package b02.strategy;

import b02.game.*;


public class TTTGameStrategy implements GameStrategy{
	
	Game g = new TTTGame();
	MinMaxStrategy mms;
	
	public TTTGameStrategy() {
		
		mms = new MinMaxStrategy();
	}

	@Override
	public Move nextMove(Game g) {
		// Naechsten Zug berechnen
		return mms.nextMove(g);
	}

}
