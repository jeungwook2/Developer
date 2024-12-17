package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import board.BoardController;
import member.MemberController;
import member.MemberVo;

public class Main {

	public static Scanner sc;
	public static MemberVo loginMemberVo;
	
	public static void main(String[] args) {

		BoardController bc = new BoardController();
		MemberController mc = new MemberController();
		
		while(true) {
			System.out.println("1. BOARD");
			System.out.println("2. MEMBER");
			System.out.println("9. EXIT");
			System.out.print("번호 입력 : ");
			String num = sc.nextLine();
			
			switch(num) {
			case "1" : bc.menu(); break;
			case "2" : mc.menu(); break;
			case "9" : System.out.println("프로그램 종료"); return;
			}
	
		}//while
		
	}//main

}//class
