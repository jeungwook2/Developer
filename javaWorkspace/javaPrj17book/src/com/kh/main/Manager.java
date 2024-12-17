package com.kh.main;

import java.util.Scanner;

public class Manager {

	Book[] bookArr = new Book[100];
	int idx;
	Scanner sc = new Scanner(System.in);
	
	
	//도서 등록
	public void enrollBook() {
		System.out.println("----- 도서 등록 -----");
		
		// 데이터 입력받기
		System.out.print("제목 : ");
		String name = sc.nextLine();

		System.out.print("장르 : ");
		String genre = sc.nextLine();
		
		// 객체 만들기
		Book b = new Book();
		b.no = idx+1;
		b.name = name;
		b.genre = genre;
		
		// 객체 저장하기
		bookArr[idx] = b;
		idx++;
	}
	
	public void printAllBook() {
		// 배열의 모든 요소 출력
		System.out.println("----- 전체 도서 목록 -----");
		System.out.println("번호 / 제목 / 장르");
		for(int i=0; i<idx; ++i) {
			if(bookArr[i] != null) {
				System.out.println(bookArr[i].no + " / " + bookArr[i].name + " / " + bookArr[i].genre);
			}
		}
	}

	public void printBook() {
		System.out.println("----- 도서 상세 조회 -----");
		System.out.println("도서 번호 :");
		String num = sc.nextLine();
		int n = Integer.parseInt(num);
		
		printBook(n);
	}
	
	public void printBook(int num) {
		for(int i=0; i<idx; ++i) {
			if(bookArr[i].no == num) {
				System.out.println(bookArr[i].no + " / " + bookArr[i].name + " / " + bookArr[i].genre);
				return;
			}
		}
		System.out.println("해당 번호의 책은 없습니다.");
	}
	
	public void deleteBook() {
		
		// 번호 입력받기
		System.out.print("번호를 입력하세요 : ");
		String num_ = sc.nextLine();
		int num = Integer.parseInt(num_);
		
		// 배열 중 해당 도서 삭제하기, 값을 null 로 변경
		bookArr[num-1] = null;
		System.out.println("삭제 완료 !");
		
	}
	
}
