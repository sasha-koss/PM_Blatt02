package app;

import java.util.Random;

import b02.game.Game;
import b02.game.Move;
import b02.strategy.GameStrategy;

public class RndStrategy implements GameStrategy{

	public RndStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move nextMove(Game g) {
		// TODO Auto-generated method stub
		return g.remainingMoves().get(new Random().nextInt(g.remainingMoves().size()));
	}
}
