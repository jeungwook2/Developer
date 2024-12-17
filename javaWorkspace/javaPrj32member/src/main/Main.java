package main;

import member.controller.MemberController;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== MEMBER =====");
		
		MemberController controller = new MemberController();
		
		while(true) {
			controller.menu();
		}
	}

}
