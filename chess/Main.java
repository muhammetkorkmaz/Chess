package chess;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//url of txt folders 
		final String board1="C:\\Users\\muhammet\\eclipse-workspace\\chess\\src\\chess\\Datas\\board1.txt";
		final String board2="C:\\Users\\muhammet\\eclipse-workspace\\chess\\src\\chess\\Datas\\board2.txt";
		final String board3="C:\\Users\\muhammet\\eclipse-workspace\\chess\\src\\chess\\Datas\\board3.txt";
		
		ChessBoard cb=new ChessBoard(board3);
		cb.calculatePoints();
		
		System.out.println("Siyah puan: "+ChessBoard.blackPoint);
		System.out.println("Beyaz puan: "+ChessBoard.whitePoint);
		
	}

}
