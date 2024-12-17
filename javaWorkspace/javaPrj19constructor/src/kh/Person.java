package kh;

public class Person {

	// 기본생성자
	public Person() {
		
	}
	
	
	// 매개변수가 있는 생성자
	public Person(String name, int age) {
		System.out.println("Person 생성자 호출됨~~~");
		this.name = name;
		this.age = age;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name.length() >= 2) {
			this.name = name;
		}
	}
	
	private int age;

	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
	}
}
