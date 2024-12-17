package kh;

import java.util.Scanner;

public class GameManager {

	public void rcpGameStart() {
		
		System.out.println("===== 가위바위보 =====");
		
		// 유저한테 손 입력받기
		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();
		
		// 컴퓨터 손 랜덤으로 설정하기
		int random = (int)(Math.random() * 3 + 1);
		String com = "";
		
		if(random==1) {
			com = "가위";
		}
		else if(random==2) {
			com = "바위";
		}
		else {
			com = "보";
		}
		
		// 각자의 손 출력
		System.out.println("user : " + user);
		System.out.println("com : " + com);
		
		// 승 패 판단하여 출력
		if(user.equals(com)) {
			System.out.println("무승부");
		}
		else if(com.equals("가위") && user.equals("바위")) {
			System.out.println("유저 승리 !");
		}
		else if(com.equals("가위") && user.equals("보")) {
			System.out.println("유저 패배 ...");
		}
		else if(com.equals("바위") && user.equals("보")) {
			System.out.println("유저 승리 !");
		}
		else if(com.equals("바위") && user.equals("가위")) {
			System.out.println("유저 패배 ...");
		}
		else if(com.equals("보") && user.equals("가위")) {
			System.out.println("유저 승리 !");
		}
		else if(com.equals("보") && user.equals("바위")) {
			System.out.println("유저 패배 ...");
		}
	}
	
}
