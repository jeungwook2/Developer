package main;

import board.BoardManager;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 게시판 =====");
		
		BoardManager bm = new BoardManager();
		
		while(true) {
			bm.menu();
		}
		
	}

}
