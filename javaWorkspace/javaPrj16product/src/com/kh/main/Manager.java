package com.kh.main;

import java.util.Scanner;

public class Manager {
	
	Product[] productArr = new Product[100];
	int idx;
	Scanner sc = new Scanner(System.in);

	public void enroll() {
		System.out.println("----- 상품 등록 -----");
		
		//상품 정보 입력받기
		System.out.print("상품 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("상품 가격 : ");
		String price_ = sc.nextLine();
		int price = Integer.parseInt(price_); // int 타입으로 변환
		
		System.out.print("상품 갯수 : ");
		String cnt_ = sc.nextLine();
		int cnt = Integer.parseInt(cnt_);
		
		//상품 객체 만들기
		Product p = new Product();
		p.name = name; 
		p.price = price;
		p.cnt = cnt;
		
		//객체를 저장해두기
		productArr[idx] = p;
		idx++;
	}
	
	public void printAllProduct() {
		//저장된 상품 정보 출력
		System.out.println("----- All Product -----");
		for(int i=0; i<idx; i++) {
			System.out.println(productArr[i].name + " / " + productArr[i].price + " / " + productArr[i].cnt);
		}
	}
	
	// 

	public void plus() {
		System.out.println("----- 상품 재고 수정(추가하기) -----");
		// 상품명, 추가할 갯수 입력받기
		System.out.print("추가할 상품 이름 : ");
		String s = sc.nextLine();
		System.out.print("추가할 상품 갯수 : ");
		String n_ = sc.nextLine();
		int n = Integer.parseInt(n_);
		
		plus(s, n);
	}
	
	public void plus(String s, int n) {
		// 특정 상품 객체 찾아서, cnt 값을 증가
		for(int i=0; i<idx; i++) {
			if(productArr[i].name.equals(s)) {
				productArr[i].cnt += n;
				System.out.println(s + "(" + n + "개) 입고 처리 완료");
				return; // plus 메서드를 호출한 곳으로 돌아감
			}
		}
		System.out.println("그런 상품은 없습니다. 상품 이름을 확인해주세요.");
	}
	
	public void minus() {
		System.out.println("----- 상품 재고 수정(추가하기) -----");
		// 상품명, 제거할 갯수 입력받기
		System.out.print("제거할 상품 이름 : ");
		String s = sc.nextLine();
		System.out.print("제거할 상품 갯수 : ");
		String n_ = sc.nextLine();
		int n = Integer.parseInt(n_);
		
		minus(s, n);
	}
	
	public void minus(String s, int n) {
		// 특정 상품 객체 찾아서, cnt 값을 감소
		for(int i=0; i<idx; i++) {
			if(productArr[i].name.equals(s)) {
				productArr[i].cnt -= n;
				System.out.println(s + "(" + n + "개) 제거 처리 완료");
				return; // plus 메서드를 호출한 곳으로 돌아감
			}
		}
		System.out.println("그런 상품은 없습니다. 상품 이름을 확인해주세요.");
	}
	
	public void printMenu() {
		System.out.println("\n\n");
		System.out.println("----- MENU -----");
		System.out.println("1. 상품 등록");
		System.out.println("2. 상품 전체조회");
		System.out.println("3. 상품 재고 플러스");
		System.out.println("4. 상품 재고 마이너스");
		System.out.println("9. 프로그램 종료");
	}
	
//	상품등록;
//	상품정보확인(재고확인);
//	재고플러스;
//	재고마이너스;
//	상품검색;
	
	
}
