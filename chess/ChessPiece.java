package chess;

import java.awt.Point;
 
abstract class ChessPiece {
	
	//Chess Piece variables 
	protected Point location;
	protected String color; 
	protected String[][] board;
	
	//Constructor
	//location: type=point, location of spessific chess piece
	//   color: type=string, color of chess piece
	//   board: type=2d string array, store all pieces on board
	ChessPiece(Point location,String color,String[][] board){
		this.location=location;
		this.color=color;
		this.board=board;
	}

	//abstract function
	protected abstract void checkThreatDirection(Point location,int directionX,int directionY); 
	
	//x: type=int, store x coordinate
	//y: type=int, store y coordinate
	//if x,y coordinate is valid return true, if not return false
	protected boolean isValid(int x,int y) {
	
		if(x<0 || x>7 || y<0 || y>7)
			return false;
		else
			return true;
	}
	
	//x: type=int, store x coordinate
	//y: type=int, store y coordinate
	//color: type=String, chess pieces own color
	//if piece on x,y is opponent return -1
	//if piece on x,y is own return +1
	//if piece on x,y is empty return 0
	protected int checkBoardSquare(int x,int y,String color) {
		
		char opponentColor=board[y][x].charAt(1);
		
		if(board[y][x].equals("xx"))
			return 0;
		else if(color=="black" && opponentColor=='b')
			return -1;
		else if(color=="black" && opponentColor=='s')
			return +1;
		else if(color=="white" && opponentColor=='b')
			return +1;
		else if(color=="white" && opponentColor=='s')
			return -1;
		else
			return -99;
	}
	
	//x: type=int, store x coordinate
	//y: type=int, store y coordinate
	//return turue if the piece on x,y is already threatened from other opponent pieces
	protected boolean checkIsThreatened(int x,int y) {
		
		if(ChessBoard.threatenedPieces.contains(new Point(x,y)))
			return true;
		else
			return false;
	}
	
	//type, store chess piece type like horse, elephant
	//color: type=String, chess pieces own color
	protected void decreasePoint(char type,String color) {
		
		if(type=='p') {
			if(color=="black")
				ChessBoard.whitePoint-=0.5;
			else
				ChessBoard.blackPoint-=0.5;
		}
		else if(type=='a') {
			if(color=="black")
				ChessBoard.whitePoint-=1.5;
			else
				ChessBoard.blackPoint-=1.5;
		}
		else if(type=='f') {
			if(color=="black")
				ChessBoard.whitePoint-=1.5;
			else
				ChessBoard.blackPoint-=1.5;
		}
		else if(type=='k') {
			if(color=="black")
				ChessBoard.whitePoint-=2.5;
			else
				ChessBoard.blackPoint-=2.5;
		}
		else if(type=='v') {
			if(color=="black")
				ChessBoard.whitePoint-=4.5;
			else
				ChessBoard.blackPoint-=4.5;
		}
		else if(type=='s') {
			if(color=="black")
				ChessBoard.whitePoint-=50;
			else
				ChessBoard.blackPoint-=50;
		}
		
	}
	
	
	
}
