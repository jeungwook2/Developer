package main;

import test.Person;
import test.Programmer;

public class Main {

	public static void main(String[] args) {
		
//		Pokemon p = new Pikachu();
//		p.bodyAttack();
		
		test.WebProgrammer webProgrammer = new test.WebProgrammer();
		
		if(webProgrammer instanceof Person) {
			System.out.println("Person 타입 맞음");
		}
		if(webProgrammer instanceof Programmer) {
			System.out.println("Programmer 타입 맞음");
		}
		if(webProgrammer instanceof test.WebProgrammer) {
			System.out.println("WebProgrammer 타입 맞음");
		}
		
	}

}
