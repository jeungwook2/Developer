package main;

import board.BoardController;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== BOARD =====");
		
		BoardController bc = new BoardController();
		
		while(true) {
			bc.menu();
		}
		
		
	}

}
