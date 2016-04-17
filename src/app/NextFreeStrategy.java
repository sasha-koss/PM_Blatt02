package app;

import b02.game.Game;
import b02.game.Move;
import b02.strategy.GameStrategy;

public class NextFreeStrategy implements GameStrategy {

	public NextFreeStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move nextMove(Game g) {
		// TODO Auto-generated method stub
		return g.remainingMoves().get(1);
	}

}
