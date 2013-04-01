/* MachinePlayer.java */

package player;

/**
 *  An implementation of an automatic Network player.  Keeps track of moves
 *  made by both players.  Can select a move for itself.
 */
public class MachinePlayer extends Player {
    public final static int COMPUTER_WIN = 1;
    public final static int HUMAN_WIN = -1;
    protected int color;
    protected int searchDepth;
    protected Board board;
    public static final boolean COMPUTER = true;
    //THERE IS A METHOD FOR FINDING THE OPPONENT COLOR 
    //DO NOT NEED TO ADD A FIELD
    

  /*
  * Creates a machine player with the given color.  Color is either 0 (black)
  *or 1 (white).  (White has the first move.)
  *@param color the color of the player
  */
  public MachinePlayer(int color) {
      this.color = color;
	 // this.searchDepth = some arbitary depth
	  board = new Board();

  // Creates a machine player with the given color and search depth.  Color is
  // either 0 (black) or 1 (white).  (White has the first move.)
  public MachinePlayer(int color, int searchDepth) {
	  this.color = color;
	  this.searchDepth = searchDepth;
	  board = new Board();
  }

  // Returns a new move by "this" player.  Internally records the move (updates
  // the internal game board) as a move by "this" player.
  public Move chooseMove() {
	  Move best = findBest(color);
	  board.makeMove(best,color);
	  return best;
	  
  } 

  // If the Move m is legal, records the move as a move by the opponent
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method allows your opponents to inform you of their moves.
  public boolean opponentMove(Move m) {
    if (board.isValidMove(m)){
    	board.makeMove(m,opponentColor());
    	return true;
    }
    return false;
  }

  // If the Move m is legal, records the move as a move by "this" player
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method is used to help set up "Network problems" for your
  // player to solve.
  public boolean forceMove(Move m) {
    if (isValidMove(m)){
    	board.makeMove(m,color);
    	return true;
    }
    return false;
  }

/// GAME-TREE SEARCH MODULE

/*  minimax() assigns a score to a board on the game tree. It is part of the Game Tree Search Module. It
    contains two important functions. It primarily checks if there is a network on the current board (by calling the and 
   then assigns a score based on recursively evaluating the next boards to a certain depth in order to 
   choose the next best possible move. It also needs to check if it is more advantageous to move forward for itself 
   or to ruin the opponent's network in progress. 
        * @param side is the color of the player who's moves we are currently looking for.
        * @param depth is how many more turns the algorithm can look ahead for a network or to evaluate a score.
        * @param alpha is the score the computer knows with certainty it can achieve.
        * @param beta is the score the opponent knows with certainty it can achieve.
        * @returns a Move which holds the highest scoring move.
        * DO I NEED TO GIVE IT A BOARD OR JUST A PARTICULAR MOVE?
        * Requires a method to check Opponents progress
        */
  private BestMove minimax(int side, int depth, int alpha, int beta){
	  BestMove best = new BestMove();
	  BestMove reply;
	  //WHAT IS THE POINT OF SIDE
	  
	  if (board.hasNetwork(color) || board.hasNetwork(opponentColor()) ||depth ==0){
		  best.score = evaluateBoard(board);
		  return best;
	  }
	  if (side == COMPUTER){
		  best.score = alpha;
	  }else{
		  best.score = beta;
	  }
	  //go into some sort of loop
	  //make a new move object
	  //determine if it is valid
	  //or just call valid moves...?
	  DList moves = validMoves(color);
	  DListNode moveNode = move.front();
	  while (moveNode != null){//or isValid or whatever
		  Board orig = board.clone();
		  //Board tryMoveBoard = board;
		  /*tryMove*/board.makeMove(moveNode.item());
		 // board = tryMoveBoard; 
		  reply = minimax(!side, depth-1, alpha, beta);
		  board = orig;
		  //need a bestmove class w/ a move and score.
		  if ((side == COMPUTER) && (reply.score >= best.score)){
			  best.move = moveNode.item();
			  best.score = reply.score;
			  alpha = reply.score;
		  }else if ((side != COMPUTER) && (reply.score <= best.score)){
			  best.move = moveNode.item();
			  best.score = reply.score;
			  beta = reply.score;
		  }
		  if (alpha >= beta){
			  return best;
		  }
		  moveNode = moveNode.next();
	  }
	  return best;
	  //create a new board with each move from valid moves one by one
	  //score each board with eval board
	  //do something with alphas and betas
	  //do some recursive call, changing depth
		  
	  
	  
	  /*if (side == this.color){
		  mySide = true;
	  }else
		  mySide = false;
	  //lotsa stuff in between
	  if (board.hasNetwork(color) || depth ==0){
		  score = 1;
	  }
	  if (side){
		  best score = alpha
	  }else
		  best score = beta;
		  */
	  
  }
 
  /**
   * Uses minimax to find the best move possible
   * May want to just put this in the chooseMove method
   */
  private Move findBest(int color){
	  int alpha = -2;
	  int beta =2;
	  BestMove bestMove;
	  boolean side;
	  if (this.color == color){
		  side = true;
	  }else
		  side = false;
	  bestMove = minimax(side, searchDepth, alpha, beta);
	  return bestMove.move;
  }
  private int opponentColor(){
	  if (color == Board.WHITE){
		  return Board.BLACK;
	  }else 
		  return Board.WHITE;
  }
  
  
/*
        * evaluateBoard gives the current Board a score. This score reflects how likely it is to win if it is positive 
        and if it is negative, how likely the opponent is to win. 
        * This method is underneath the Game Tree Search Module and specifically underneath the minimax interface. 
        Minimax calls evaluateBoard after determining that the Board does not have a Network. It scores each board. 
        between -1 and 1 to represent the outcome.  Scores closer to 1 mean the MachinePlayer is more likely to win and
        scores closer to -1 mean the opponent is more likely to win.
        * @param b the Board object to be evaluated.
        * @returns an integer between -1 and 1 for likelihood of winning. 
        */
private int evaluateBoard(Board b){
    if hasNetwork(){
        return Intege
    }
    
}

}
}
