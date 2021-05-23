package chess;

import java.util.ArrayList;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ChessBoard {

	//ChessBoard variables
	private String[][] board=new String[8][8];
	private Point pieceLocation=new Point();
	static ArrayList<Point> threatenedPieces = new ArrayList<Point>();
	
	//variables store points
	static double whitePoint=139;
	static double blackPoint=139;
	
	//variables for read txt
	private int counter=0;
	String line;
	
	//Constructor
	//url: type=string, store txt folder url
	ChessBoard(String url){
		initBoard(url);
	}
	
	//get,set methots
	double getWhitePoint() {
		return whitePoint;
	}
	
	double getBlackPoint() {
		return blackPoint;
	}
	
	//url: type=string, store txt folder url
	//set 2d board array with chesspieces info
	private void initBoard(String url) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(url));
			while((line=reader.readLine()) != null ) {
	
				board[counter]=line.split("\\s");
				counter++;
			}
			reader.close();
		}
		catch(FileNotFoundException ex){
			System.out.print("Dosya bulunamadý.");
		}
		catch(IOException ex) {
			System.out.print(ex);
		}
	}

	//travel all string in 2d board
	//create chesspiece object
	//calculate every pieces threats
	void calculatePoints() {
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(!board[i][j].equals("xx")) {
					if(board[i][j].charAt(0)=='a' && board[i][j].charAt(1)=='s') {
						pieceLocation.setLocation(j, i);
						Horse h=new Horse(pieceLocation,"black",board);
						h.checkAllThreats(pieceLocation);
						
					}
					else if(board[i][j].charAt(0)=='a' && board[i][j].charAt(1)=='b') {
						pieceLocation.setLocation(j, i);
						Horse h=new Horse(pieceLocation,"white",board);
						h.checkAllThreats(pieceLocation);
						
					}
					else if(board[i][j].charAt(0)=='f' && board[i][j].charAt(1)=='s') {
						pieceLocation.setLocation(j, i);
						Elephant e=new Elephant(pieceLocation,"black",board);
						e.checkAllThreats(pieceLocation);

					}
					else if(board[i][j].charAt(0)=='f' && board[i][j].charAt(1)=='b') {
						pieceLocation.setLocation(j, i);
						Elephant e=new Elephant(pieceLocation,"white",board);
						e.checkAllThreats(pieceLocation);

					}
				}
			}
		}
	}
}
