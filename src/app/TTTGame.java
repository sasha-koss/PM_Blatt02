package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import b02.game.Game;
import b02.game.Move;
import b02.game.Player;

public class TTTGame implements Game{
	
	Player pX,pO,pActive;
	//List<TTTMove> gameMoves;
	//List<Move> remainingMoves;
	char[][] field;
	boolean ended= false;
	
	public TTTGame() {

		//this.gameMoves = new ArrayList<TTTMove>();
		//this.remainingMoves = new ArrayList<Move>();
		this.field = new char[3][3];
		for(int i = 0; i<3;i++){
			for(int j = 0; j<3;j++){
				//this.gameMoves.add(new TTTMove(i,j));
				//this.remainingMoves.add(new TTTMove(i,j));
				this.field[i][j]=' ';
			}
		}
	}

	@Override
	public void setPlayerX(Player p) {
		if (this.pActive==null) this.pActive = p;
		this.pX = p;
	}

	@Override
	public void setPlayerO(Player p) {
		this.pO = p;
	}

	@Override
	public Player currentPlayer() {
		return this.pActive;
	}

	@Override
	public List<Move> remainingMoves() {
		List<Move> tmpList = new ArrayList<Move>();
		for(int i = 0; i<3;i++){
			for(int j = 0; j<3;j++){
				//this.gameMoves.add(new TTTMove(i,j));
				if(this.field[i][j]==' ')	tmpList.add(new TTTMove(i,j));
			}
		}
		return tmpList;
	}

	@Override
	public void doMove(Move m) {
		
		if (!ended && m!=null){		
		int row = m.getRow();
		int column = m.getColumn();
		this.field[row][column] = this.currentPlayer().getSymbol();
		evalState(pActive);
		if(this.pActive==this.pX) this.pActive=this.pO;
		else this.pActive=this.pX;
		
		}
	}

	@Override
	public void undoMove(Move m) {
		field[m.getRow()][m.getColumn()] = ' ';
		if(pActive==pX) pActive=pO;
		else pActive=pX;
		ended = false;
	}

	@Override
	public boolean ended() {
		return this.ended;
	}

	@Override
	public int evalState(Player p) {
	    // Bewertung des Zustandes aus Sicht des Players p
	    // +1: p hat gewonnen
	    // -1: p hat verloren
	    // 0: Unentschieden

		int winCounter=0;
		//horizontal
		for(int i = 0; i < 3; i++)
		{	
			for(int ii = 0; ii < 3; ii++)		
			{
				if(field[i][ii]==p.getSymbol()) winCounter++;
				if(field[i][ii]!=p.getSymbol() && field[i][ii]!=' ') winCounter--;
			}
			if(winCounter==3) {
				this.ended = true;
				return 1;
			}
			if(winCounter==-3) {
				this.ended = true;
				return -1;
			}
		}

		winCounter=0;
		
		//vertical
		for(int i = 0; i < 3; i++)
		{	
			for(int ii = 0; ii < 3; ii++)		
			{
				if(field[ii][i]==p.getSymbol()) winCounter++;
				if(field[ii][i]!=p.getSymbol() && field[ii][i]!=' ') winCounter--;
			}
			
		}
		if(winCounter==3) {
			this.ended = true;
			return 1;
		}
		if(winCounter==-3) {
			this.ended = true;
			return -1;
		}
		winCounter=0;
		
		//diagonal
		for(int i = 0 ;i<3;i++){
			if(field[i][i]==p.getSymbol()) winCounter++;
			if(field[i][i]!=p.getSymbol() && field[i][i]!=' ') winCounter--;
		}
		if(winCounter==3) {
			this.ended = true;
			return 1;
		}
		if(winCounter==-3){
			this.ended = true;
			return -1;
		}
		
		winCounter=0;
		//anti diagonal
		for(int i = 0; i < 3; i++)
		{	
			for(int ii = 2; ii < 0; ii--)		
			{
				if(field[i][ii]==p.getSymbol()) winCounter++;
				if(field[i][ii]!=p.getSymbol() && field[i][ii]!=' ') winCounter--;
			}
			
		}
		if(winCounter==3) {
			this.ended = true;
			return 1;
		}
		if(winCounter==-3) {
			this.ended = true;
			return -1;
		}
		
		winCounter=0;
		for(int i = 0; i<3;i++){
			for(int j = 0; j<3;j++){
				//this.gameMoves.add(new TTTMove(i,j));
				if(this.field[i][j]!=' ')	winCounter++;
			}
		}
		
		if (winCounter==9){
			this.ended = true;
			return 0;
		}
		
		
		else return -20;		
	}

	@Override
	public void printField() {
		for(int i = 0; i<3;i++){
				
				System.out.println(this.field[i][0]+"|"+this.field[i][1]+"|"+this.field[i][2]);
				
		}
		System.out.println("----------------------------------------------");
	}

}
