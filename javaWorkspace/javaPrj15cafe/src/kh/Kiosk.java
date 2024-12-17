package kh;

import java.util.Scanner;

public class Kiosk {

	OrderInfo info = new OrderInfo();
	
	String menu01name = "아메리카노";
	String menu02name = "아이스티";
	String menu03name = "녹차";
	
	int menu01price = 1000;
	int menu02price = 2000;
	int menu03price = 3000;
	
	
	// 메뉴 선택(+수량)
	public void selectMenu() {
		//메뉴판 보여주기
		System.out.println("==========MENU==========");
		System.out.println("1. " + menu01name + " / " + menu01price);
		System.out.println("2. " + menu02name + " / " + menu02price);
		System.out.println("3. " + menu03name + " / " + menu03price);
		System.out.println("========================");
		
		//메뉴 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1 :	
			info.menu = menu01name;
			info.menuPrice = menu01price;
			break;
		case 2 :	
			info.menu = menu02name; 
			info.menuPrice = menu02price;
			break;
		case 3 :	
			info.menu = menu03name; 
			info.menuPrice = menu03price;
			break;
		}
		
		//수량 입력받기
		System.out.print("수량 : ");
		info.cnt = sc.nextInt(); // this 안써도됨
		
	}
	
	// 주문 내용 출력(메뉴, 수량, 총 가격)
	public void printOrder() {
		System.out.println("=====주문내역=====");
		System.out.println("메뉴 : " + info.menu);
		System.out.println("수량 : " + info.cnt);
		System.out.println("가격 : " + info.cnt * info.menuPrice);
		System.out.println("================");
	}
	
}
