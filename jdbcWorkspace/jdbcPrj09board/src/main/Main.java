package main;

import board.BoardController;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("===== Board =====");
		
		BoardController bc = new BoardController();
		
		while(true) {
			bc.menu();
		}
	}

}
