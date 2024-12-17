package main;

import java.util.Scanner;

import bank.BankController;
import member.MemberController;
import member.MemberVo;

public class Main {

	public static Scanner sc;
	public static MemberVo loginMemberVo;

	public static void main(String[] args) {
		
		BankController bc = new BankController(); 
		MemberController mc = new MemberController(); 
		sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. BANK");
			System.out.println("2. MEMBER");
			System.out.println("9. EXIT");
			System.out.print("번호 입력 : ");
			String num = sc.nextLine();
			
			switch(num) {
			case "1" : bc.menu(); break;
			case "2" : mc.menu(); break;
			case "9" : System.out.println("프로그램 종료 ... "); return;
			}
		}
		
	}//main

}//class
