package main;

import kh.Person;
import kh.User;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 생성자 =====");
		
//		User x = new User();
//		x.setId("user01");
//		x.setPwd("1234");
//		x.setNick("1dragon");
//		x.setHeight(197.3);
//		x.setWeight(43.2);
//		x.setQuit(false);

		User x = new User("user01", "1234", "1dragon", 20, 197.3, 43.2, false);
		
		System.out.println(x);
		
	}//main

}//class
