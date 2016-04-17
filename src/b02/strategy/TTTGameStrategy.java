package b02.strategy;

import b02.game.*;


public class TTTGameStrategy implements GameStrategy{
	
	Game g = new TTTGame();
	MinMaxStrategy mms;
	
	public TTTGameStrategy() {
		// TODO Auto-generated constructor stub
		mms = new MinMaxStrategy();
	}

	@Override
	public Move nextMove(Game g) {
		// TODO Auto-generated method stub
		return mms.nextMove(g);
	}

}
