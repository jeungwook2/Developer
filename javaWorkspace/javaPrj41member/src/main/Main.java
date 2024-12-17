package main;

import member.MemberController;

public class Main {
	
	public static void main(String[] args) throws Exception{

		System.out.println("===== MEMBER =====");

		MemberController mc = new MemberController();
		while(true) {
			mc.menu();
		}
		
	}//main

}//class
