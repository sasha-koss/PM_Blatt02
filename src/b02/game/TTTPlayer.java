package b02.game;

import b02.strategy.*;

public class TTTPlayer implements Player {

	char pSymbol;
	GameStrategy gs;
	
	public TTTPlayer(char pSymbol){
		this.pSymbol = pSymbol;
		gs = new TTTGameStrategy();
	}
	
	@Override
	public void setStrategy(GameStrategy s) {
		this.gs = s;
	}

	@Override
	public Move nextMove(Game g) {
		return gs.nextMove(g);
	}

	@Override
	public char getSymbol() {
		return pSymbol;
	}

}
