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
		// TODO Auto-generated method stub
		this.gs = s;
	}

	@Override
	public Move nextMove(Game g) {
		// TODO Auto-generated method stub			
		return gs.nextMove(g);
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return pSymbol;
	}

}
