package main;

import member.controller.MemberController;

public class Main {

	public static void main(String[] args) {
		
		MemberController controller = new MemberController();
		
		while(true) {
			boolean isFinish = controller.menu();
			if(isFinish) {
				break;
			}
		}
	}

}
