/**
 * This class is literally just a data structure that holds a Move 
 * object and a score for that move object.
 * NOT an  ADT
 */

public class BestMove {
	
	public int score;
	public Move move;
	
	public BestMove(){
		score =0;
		move =  new Move();
	}

}