package chess;

import java.awt.Point;

public class Elephant extends ChessPiece{
	
	//call parent Constructor
	Elephant(Point location,String color,String[][] board){
		super(location,color,board);
	}

	//location: type=point, location of spessific chess piece
	//directionX: type=int, x coordinate of  threat direction
	//directionY: type=int, y coordinate of threat direction
	//decrease black or white point if opponent piece on direction x,y is exist 
	@Override
	protected void checkThreatDirection(Point location, int directionX, int directionY) {
		// TODO Auto-generated method stub
		if(!isValid(location.x+directionX,location.y+directionY))
			return;
		
		else {
			if(checkBoardSquare(location.x+directionX,location.y+directionY, this.color)==0) {
				Point newLocation=new Point(location.x+directionX,location.y+directionY);
				checkThreatDirection(newLocation,directionX,directionY);
			}
			else if(checkBoardSquare(location.x+directionX,location.y+directionY, this.color)==1)
				return;
			else if(checkBoardSquare(location.x+directionX,location.y+directionY, this.color)==-1 
					&& !checkIsThreatened(location.x+directionX, location.y+directionY)) 
			{
				decreasePoint(board[location.y+directionY][location.x+directionX].charAt(0),color);
				ChessBoard.threatenedPieces.add(new Point(location.x+directionX,location.y+directionY));
				return;
			}
		}
	}

	//location: type=point, location of spessific chess piece
	//check all direction for elephant
	public void checkAllThreats(Point location) {
	
		checkThreatDirection(location,+1,+1);
		checkThreatDirection(location,+1,-1);
		checkThreatDirection(location,-1,+1);
		checkThreatDirection(location,-1,-1);
	}
}
