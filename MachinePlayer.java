/* MachinePlayer.java */

package player;

/**
 *  An implementation of an automatic Network player.  Keeps track of moves
 *  made by both players.  Can select a move for itself.
 */
public class MachinePlayer extends Player {
    public final static int COMPUTER_WIN = 1;
    public final static int HUMAN_WIN = -1;
    
    

  /*
  * Creates a machine player with the given color.  Color is either 0 (black)
  *or 1 (white).  (White has the first move.)
  *@param color the color of the player
  */
  public MachinePlayer(int color) {
  }

  // Creates a machine player with the given color and search depth.  Color is
  // either 0 (black) or 1 (white).  (White has the first move.)
  public MachinePlayer(int color, int searchDepth) {
  }

  // Returns a new move by "this" player.  Internally records the move (updates
  // the internal game board) as a move by "this" player.
  public Move chooseMove() {
    return new Move();
  } 

  // If the Move m is legal, records the move as a move by the opponent
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method allows your opponents to inform you of their moves.
  public boolean opponentMove(Move m) {
    return false;
  }

  // If the Move m is legal, records the move as a move by "this" player
  // (updates the internal game board) and returns true.  If the move is
  // illegal, returns false without modifying the internal state of "this"
  // player.  This method is used to help set up "Network problems" for your
  // player to solve.
  public boolean forceMove(Move m) {
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
  private Move minimax(int side, int depth, int alpha, int beta){}
  
  
/*
        * evaluateBoard gives the current Board a score. This score reflects how likely it is to win if it is positive 
        and if it is negative, how likely the opponent is to win. 
        * This method is underneath the Game Tree Search Module and specifically underneath the minimax interface. 
        Minimax calls evaluateBoard after determining that the Board does not have a Network. It scores each board. 
        between -1 and 1 to represent the outcome.  Scores closer to 1 mean the MachinePlayer is more likely to win and
        scores closer to -1 mean the opponent is more likely to win.
        * @param b the Board object to be evaluated.
        * @returns an integer between -1 and 1 for likelihood of winning. 
        * IS THIS A FLOAT?
        */
  
private int evaluateBoard(Board b){}



// VALID MOVES MODULE


/*Uses the rules of the game and positions of the current chips
*to generate a list of valid moves
*@return an array of Move objects which represent valid moves for the current game situation
*/
private Move[] validMoves(){}

/*Determines whether a move is valid or not
*@return a Move object if the move requested is valid
*null otherwise
*/
private Move isValid() {}





}
}
