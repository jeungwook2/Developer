package com.kh.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Manager m = new Manager();
		Scanner sc = new Scanner(System.in);

		System.out.println("===== product =====");
		
		while(true) {
			m.printMenu();
			
			System.out.print("메뉴 번호 : ");
			String num = sc.nextLine();
			
			
			switch(num) {
			case "1" : m.enroll(); break; 
			case "2" : m.printAllProduct(); break;
			case "3" : m.plus(); break;
			case "4" : m.minus(); break;
			case "9" : System.out.println("프로그램 종료"); return;
			default  : System.out.println("잘못 입력하셨습니다.");
			}
		}
		
		
	}

}
