package app;

import b02.game.Game;
import b02.game.Move;
import b02.game.Player;
import b02.strategy.*;

public class TTTPlayer implements Player {

	private char pSymbol;
	private GameStrategy gs;
	
	public TTTPlayer(char pSymbol){
		this.pSymbol = pSymbol;
		//this.gs = new GameStrategy();
	}
	
	@Override
	public void setStrategy(GameStrategy s) {
		this.gs = s;
	}

	@Override
	public Move nextMove(Game g) {
		Move m = this.gs.nextMove(g);
		return m;
	}

	@Override
	public char getSymbol() {
		return this.pSymbol;
	}

}
