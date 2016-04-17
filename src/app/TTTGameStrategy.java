package app;

import b02.game.*;
import b02.strategy.GameStrategy;
import b02.strategy.MinMaxStrategy;


public class TTTGameStrategy implements GameStrategy{
	
	Game g = new TTTGame();
	MinMaxStrategy mms;
	
	public TTTGameStrategy() {	
		this.mms = new MinMaxStrategy();
	}

	@Override
	public Move nextMove(Game g) {
		// Naechsten Zug berechnen
		return this.mms.nextMove(g);
	}

}
