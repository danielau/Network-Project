/* Board.java */


//BOARD MODULE
package player;

import java.util.Arrays;

/**
 * A class that is extended by all Network players (human and machine). 
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
    priavte int[][] corner = 

//Board Corners
    private final static int[] BOTTOM_RIGHT = {7, 7};
    private final static int[] TOP_RIGHT = {7, 0};
    private final static int[] BOTTOM_LEFT = {0, 7};
    private final static int[] TOP_LEFT = {0, 0};

// More Fields to include : Goal Areas, Rows, Columns, Diagonals


     public Board() {
		for (int i = 0; i<8; i++) {
			for (int y =0; y<8; y++) {
				gameBoard[i][y] = Board.EMPTY;
			}
		}
	}
//DO END CHECKING FOR THESE??
 private int[] getColumn(int x){
	 int[] col = new int[8];
	 for (int j =0; j<8; j++){
		 col[j] = getSquare(x,j);
	 }
 }
 
 private int[] getRow(int y){
	 int[] row = new int[8];
	 for (int i=0; i<8; i++){
		 row[i] = getSquare(i, y);
	 }
 }
 
 private DList getDiagonals(int x, int y){
	 DList diagonals = new DList();
	 //up left
	 i=x-1;
	 j=y-1;
	 while(i>0 && j>0){
		 diagonals.insertBack(getSquare(i,j));
		 i--;
		 j--;
	 }
	 //up right
	 i=x+1;
	 j=y-1;
	 while(i<7 && j>0){
		 diagonals.insertBack(getSquare(i,j));
		 i++;
		 j--;
	 }
	 //low left
	 i=x-1;
	 j=y+1;
	 while(i>0 && j<7){
		 diagonals.insertBack(getSquare(i,j));
		 i--;
		 j++;
	 }
	 
	 //low right
	 i=x+1;
	 j=y+1;
	 while (i<7 && j<7){
		 diagonals.insertBack(getSquare(i,j));
		 i++;
		 j++;
	 }
	 return diagonals;
 }
 
 private boolean isCorner(int x, int y){
	 int[] coord = {x,y};
	 if (Arrays.equals(coord, TOP_RIGHT) || Arrays.equals(coord, TOP_LEFT) || Arrays.equals(coord, BOTTOM_RIGHT) 
			 || Arrays.equals(coord, BOTTOM_LEFT)){
		 return true;
	 }else 
		 return false;
 }
 
 private int[][] neighbors(int x, int y){
	 int[][] n = {{x,y+1}, {x,y-1}, {x+1,y+1}, {x+1,y-1}, {x+1,y},{x-1,y},{x-1,y-1},{x-1,y+1}};
	 /*int[] n ={getSquare(x, y+1), getSquare(x,y-1), getSqaure(x+1,y+1), getSquare(x+1,y-1), 
			 getSquare(x+1,y), getSquare(x-1,y),getSquare(x-1,y-1), getSquare(x-1,y+1)};*/
	 return n;
 }
 
 private boolean isClustered(int x, int y){
	 int playerColor = getSquare(x,y);
	 int[][] n= neighbors(x,y);
	 for (int i =0; i<neighbors(x,y).length;i++){
		 if (getSquare(n[i][0],n[i][1])== playerColor){
			 int[][] b = neighbors()
		 }
	 }
 }
 
//VALID MOVES MODULE


/*Uses the rules of the game and positions of the current chips
*to generate a list of valid moves
*@return an array of Move objects which represent valid moves for the current game situation
*/
private DList validMoves(int playerColor){
	//Implemented for add move type only
	DList moves = new DList();
	for (int i = 0; i<8; i++){
		for (int j =0 j<8;j++){
			Move m = new Move(i,j)
			if(isValid(m,playerColor)){
				moves.insertBack(m);
			}
		}
	}
	
}

/*Determines whether a move is valid or not
*@return a Move object if the move requested is valid
*null otherwise
*/
private Move isValid(Move m, int playerColor) {
	//implemented for add move type only
	if (getSquare(m.x1,m.y1) == -1 && !isCorner(m.x1,m,y1)){
		if (playerColor == BLACK){
			if (!inGoalArea(WHITE) && !isClustered(m.x1,m.y1,BLACK)){
				return true;
			}
		}else if (playerColor == WHITE){
			if (!inGoalArea(BLACK) && !isClustered(m.x1,m.y1,WHITE)){
				return true;
			}
		}else
			return false;
	}
	return false;
	
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


/* inGoalArea is called on this board and takes in a player. It checks if that player has
    any chips in the goal area. 
    @param player is the player we are checking if they have pieces in the goal area. 
    @returns true if there are pieces in the goal area or false if there are none. 
*/
protected boolean inGoalArea(int player) {
	if (player == Board.WHITE){
		for (int i:getRow(0)){
			if (i == Board.WHITE){
				return true;
			}
		}
		for (int i:getRow(7)){
			if (i==Board.WHITE){
				return true;
			}
		}
	}else if (player == Board.BLACK){
		for (int i:getCol(0)){
			if (i == Board.BLACK){
				return true;
			}
		}
		for (int i:getCol(7)){
			if (i==Board.BLACK){
				return true;
			}
		}
	}else
	return false;
}

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







	