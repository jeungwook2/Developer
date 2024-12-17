package main;

public class Person {
	
	String name= "김승택";
	
	public void drive(Car x) {
		System.out.println(this.name);
		x.go();
		x.stop();
	}
	
}
