package main;

import java.util.Scanner;

import board.BoardController;

public class Main {

	public static Scanner sc;
	
	public static void main(String[] args) {
		
		BoardController bc = new BoardController();
		
		while(true) {
			System.out.println("1. BOARD");
			System.out.println("9. EXIT");
			System.out.print("번호 입력 : ");
			String num = sc.nextLine();
			
			switch(num) {
			case "1" : bc.menu(); break;
			case "9" : System.out.println("프로그램 종료"); return;
			}
	
		}//while
	}

}
