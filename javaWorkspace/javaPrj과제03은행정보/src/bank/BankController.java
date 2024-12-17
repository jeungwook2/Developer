package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.Main;

public class BankController {
	
	private List<BankVo> voList;
	private int seq;
	
	public BankController() {
		Main.sc = new Scanner(System.in);
		voList = new ArrayList<BankVo>();
		seq = 1;
	}
	
	// 메뉴
	public void menu() {
		System.out.println("----- MENU -----");
		System.out.println("1. 계좌 개설");
		System.out.println("2. 계좌 조회");
		System.out.println("3. 입금");
		System.out.println("4. 출금");
		System.out.print("번호 입력 : ");
		String num = Main.sc.nextLine();
		
		switch(num) {
		case "1" : accountOpenning(); break;
		case "2" : accountChecking(); break;
		case "3" : deposit(); break;
		case "4" : withdrawal(); break;
		default: System.out.println("잘못 누르셨습니다.");
		}
	}
	
	// 계좌 개설
	public void accountOpenning() {
		
		if(Main.loginMemberVo == null) {
			System.out.println("로그인 후 사용할 수 있는 기능입니다.\n");
			return;
		}
		
		System.out.println("----- 계좌 개설 -----");
		
		System.out.print("계좌명 : ");
		String accountName = Main.sc.nextLine();
		
		BankVo vo = new BankVo(accountName, 0, seq);
		voList.add(vo);
		seq++;
	}
	
	// 계좌 조회
	public void accountChecking() {
		
		if(Main.loginMemberVo == null) {
			System.out.println("로그인 후 사용할 수 있는 기능입니다.\n");
			return;
		}
		
		System.out.println("----- 계좌 조회 -----\n");
		
		System.out.println("===== 계좌 목록 =====");
		System.out.println(voList);
		System.out.println();
		
	}
	
	// 입금
	public void deposit() {
		
		if(Main.loginMemberVo == null) {
			System.out.println("로그인 후 사용할 수 있는 기능입니다.\n");
			return;
		}
		
		System.out.println("----- 입금 -----");
		
		System.out.println("===== 계좌 목록 =====");
		System.out.println(voList);
		
		System.out.print("입금할 계좌 : ");
		String accountNo = Main.sc.nextLine();

		System.out.print("입금할 금액 : ");
		String money = Main.sc.nextLine();
		
		System.out.print(accountNo + "번 계좌에 " + money + "원 입금 하시겠습니까?(y/n)\n");
		String response = Main.sc.nextLine();
		
		if(response.equals("y")) {
			BankVo vo = voList.get(Integer.parseInt(accountNo)-1);
			vo.setMoney(vo.getMoney() + Integer.parseInt(money));
			System.out.println(money + "원 입금되었습니다.\n");
		}else if(response.equals("n")) {
			System.out.println("취소되었습니다.\n");
			return;
		}
		else {
			System.out.println("잘못된 입력입니다.\n");
		}
	}
	
	// 출금
	public void withdrawal() {
		
		if(Main.loginMemberVo == null) {
			System.out.println("로그인 후 사용할 수 있는 기능입니다.\n");
			return;
		}
		
		System.out.println("----- 출금 -----");
		
		System.out.println("===== 계좌 목록 =====");
		System.out.println(voList);
		
		System.out.print("출금할 계좌 : ");
		String accountNo = Main.sc.nextLine();

		System.out.print("출금할 금액 : ");
		String money = Main.sc.nextLine();
		
		System.out.print(accountNo + "번 계좌에 " + money + "원 출금 하시겠습니까?(y/n)\n");
		String response = Main.sc.nextLine();
		
		if(response.equals("y")) {
			BankVo vo = voList.get(Integer.parseInt(accountNo)-1);
			
			if(vo.getMoney()-Integer.parseInt(money)>=0) {
				vo.setMoney(vo.getMoney() - Integer.parseInt(money));
				System.out.println(money + "원 출금되었습니다.\n");
			}else {
				System.out.println("잔액이 " + vo.getMoney() + "원 입니다. 다시 확인해주세요. \n");
			}
			
		}
		else if(response.equals("n")) {
			System.out.println("취소되었습니다.\n");
			return;
		}
		else {
			System.out.println("잘못된 입력입니다.\n");
		}
	
		
	}
}
