package main;

import book.BookController;

public class Main {

	public static void main(String[] args) {
		System.out.println("===== 도서 관리 프로그램 =====");
	
		BookController bc = new BookController();
		while(true) {
			bc.menu();
		}
		
	}

}
