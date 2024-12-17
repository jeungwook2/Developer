package main;

import board.BoardController;

public class Main {

	public static void main(String[] args) {

		boolean isFinish = true;
		
		BoardController bc = new BoardController();
		while(isFinish) {
			isFinish = bc.menu();
		}
	}

}
