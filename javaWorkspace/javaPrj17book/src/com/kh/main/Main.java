package com.kh.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 도서 관리 프로그램 =====");

		Manager m = new Manager();
		
		while(true) {
			System.out.println("----- MENU -----");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 목록 조회");
			System.out.println("3. 도서 상세 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			
			Scanner sc = new Scanner(System.in);
			String num = sc.nextLine();
			
			switch(num) {
			case "1" : m.enrollBook(); break;
			case "2" : m.printAllBook(); break;
			case "3" : m.printBook(); break;
			case "4" : m.deleteBook(); break;
			case "9" : System.out.println("프로그램 종료"); return;
			default : System.out.println("잘못된 번호 입니다.");
			}
		}
		
	}

}
