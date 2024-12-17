package main;

import board.BoardController;
import member.MemberController;
import member.MemberVo;
import util.KhUtil;

public class Main {
	
	public static MemberVo loginMember;

	public static void main(String[] args) {
		
		System.out.println("===== MEMBER + BOARD =====");
		
		MemberController mc = new MemberController();
		BoardController bc = new BoardController();
		
		while(true) {
			System.out.println("1. MEMBER");
			System.out.println("2. BOARD");
			
			String num = KhUtil.sc.nextLine();
			
			try {
				switch(num) {
				case "1" : mc.menu(); break; 
				case "2" : bc.menu(); break; 
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}//main

}//class
