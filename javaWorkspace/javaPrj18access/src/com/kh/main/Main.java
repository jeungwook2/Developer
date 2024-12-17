package com.kh.main;

import test.Person; // 다른 파일을 가져와서 사용할 때 import

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 접근제한자 =====");
		
		Animal x = new Animal();
		x.name = "바둑이";
	
		Person p = new Person();
		p.name = "홍길동";
	}

}
