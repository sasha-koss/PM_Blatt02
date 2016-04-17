package app;


import b02.game.*;
import b02.strategy.*;

public class Main {

	public static void main(String[] args) {
		Game g = new TTTGame();
		Player pO = new TTTPlayer('O');
		Player pX = new TTTPlayer('X');
		Move m;
		int eState;
		GameStrategy gO = new InputStrategy();
		GameStrategy gX = new RndStrategy();
		//GameStrategy gO = new NextFreeStrategy();
		//GameStrategy gO = new MinMaxStrategy();
		pO.setStrategy(gO);
		pX.setStrategy(gX);
		g.setPlayerO(pO);
		g.setPlayerX(pX);
		do{
			g.printField();
			System.out.println("");
			m = g.currentPlayer().nextMove(g);
			g.doMove(m);
			
		}while(!g.ended());
		// +1: p hat gewonnen
	    // -1: p hat verloren
	    // 0: Unentschieden
		eState= g.evalState(g.currentPlayer());
		System.out.println("----------------------------------------------");
		switch(eState){
		case 1: 
			System.out.println("Player: " + g.currentPlayer().getSymbol()+ " Won!");
			break;
		case -1: 
			System.out.println("Player: " + g.currentPlayer().getSymbol() + " Lost!");
			break;
		case 0: 
			System.out.println("Tie.");
			break;
		default:
			System.out.println("Unknown Error.");
		}
		System.out.println(" ");
		g.printField();
	}

}
