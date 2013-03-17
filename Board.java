/* Board.java */


//BOARD MODULE
package player;

/**
 * A class that is extended by all Network player (human and machine). 
 * This is the player's internal representation of the board. 
 * This representation of the board is intended for the Game Tree Search Module to get and set contents on the board.  
 */

//Constructor for Board class - constructs an 8 by 8 2D array
 
public class Board {
    public final static int EMPTY = -1;
    public final static int BLACK = 0;
    public final static int WHITE = 1;

    private int[][] gameBoard = new int[8][8];
    private int whitePiecesLeft = 10;
    private int blackPiecesLeft = 10;

    #Board Corners
    private final static int[] BOTTOM_RIGHT = {1, 1};
    private final static int[] TOP_RIGHT = {-1, 1};
    private final static int[] BOTTOM_LEFT = {1, -1};
    private final static int[] TOP_LEFT = {-1, -1};

// More Fields to include : Goal Areas, Rows, Columns, Diagonals


     public Board() {
		for (int i = 0; i<8; i++) {
			for (int y =0; y<8; y++) {
				gameBoard[i][y] = Board.EMPTY;
			}
		}
	}

//Methods to Include - makeMove, getSquare, hasNetwork, inGoalArea, currentConnections
// More Methods - getRows, getColumns, isCorner, isOccupied, getSurroundings, getDiagonals
// 

/* makeMove takes a legal move and an int player and changes the board. It can make
    an add move or a step move and it labels the move as which it is. It adds the piece and needs to 
    decrement the amount of pieces left for each player.
    @param m - Takse in a move to make
    @ param playerColor - Determines which player the move is made for for chip color
*/

protected void makeMove(Move m, int playerColor){
	if (isValid(m)){
		
	}
}


/* hasNetwork returns true if this board has a network with 6 or greater length. It otherwise 
*returns false. It takes in a player because it is called on the board.
*@param player the player whose network is being determined
*@return true is this board has a network with 6 or greater length
*false otherwise
*/
protected boolean hasNetwork (int player) {}


/* isGoalArea is called on this board and takes in a player. It checks if that player has
    any chips in the goal area. 
    @param player is the player we are checking if they have pieces in the goal area. 
    @returns true if there are pieces in the goal area or false if there are none. 
*/
protected boolean inGoalArea(int player) {}

/* currentConnections returns a DList with all the pieces containing a connection to given coordinate. 
 * This is used to build a network. 
 *@param x the x coordinate of the board
 *@param y the y coordinate of the board
 *@return a DList with all the spots on the board (Move items) containing a connection to the coordinate
 */

protected DList currentConnections(int x, int y){
	int piece = getSquare (x,y);
	for (int i = 0; i<8; i++){
		for (int j =0; j<8; j++){
			if (getSquare(i,j) == piece){
				
			}
		}
	}
}


/* getSquare determines the contents of the board at a given coordinate
*@param x the x coordinate of the spot
*@param y the y coordinate of the spot
*@return the contents of the board in that spot (-1, 0, 1 for empty, black, or white)
*/

protected int getSquare(int x, int y) {
		 if (x<0 || x>7 || y<0 || y>7) {
			 return Board.EMPTY;
		 }
		 else {
			 return gameBoard[x][y];
		}
	 }
}







	