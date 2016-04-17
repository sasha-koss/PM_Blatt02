package app;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import b02.game.Game;
import b02.game.Move;
import b02.strategy.GameStrategy;

public class InputStrategy implements GameStrategy{
	private Move m;
	private Scanner sc = new Scanner(System.in);
	public InputStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move nextMove(Game g) throws InputMismatchException{
		// TODO Auto-generated method stub
		int row=0,column=0;
		System.out.println("");
		System.out.println("Valid input: 0,1,2");
		System.out.println("Player "+ g.currentPlayer().getSymbol() +" turn.");
		try {
			System.out.println("Row:");
			row=sc.nextInt();
			System.out.println("Column:");
			column=sc.nextInt();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			this.sc.close();
			System.out.println("Wrong Input! Only 0,1,2 allowed.");
			System.exit(1);
		}
		if(row >=3 || column >= 3 || row < 0 || column <0){
			System.out.println("Wrong Input! Only 0,1,2 allowed.");
			System.out.println("--------------------");
			nextMove(g);
		}
		m = new TTTMove(row,column);
		Iterator<Move> it = g.remainingMoves().iterator();
		try{
			while (it.hasNext()) {
				Move tmpMove=it.next();
			    if (tmpMove.getColumn()==column && tmpMove.getRow()==row) {
			    	return this.m;		 
			    }
			}
		}
		catch(NoSuchElementException e){}
		System.out.println("Field already taken!");
		System.out.println("--------------------");
		nextMove(g);
		return m;		
	}

}
