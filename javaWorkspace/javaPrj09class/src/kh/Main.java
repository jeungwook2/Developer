package kh;

public class Main {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.name = "김승택";
		p1.height = 170;
		p1.weight = 61.4;
		p1.bloodType = 'O';

		Person p2 = new Person();
		p2.name = "조준혁";
		p2.height = 181.7;
		p2.weight = 86;
		p2.bloodType = 'B';
		
		Person p3 = new Person();
		p3.name = "김성찬";
		p3.height = 173.6;
		p3.weight = 57.3;
		p3.bloodType = 'A';

		
		System.out.println(p1.name +" / "+ p1.height +" / "+ p1.weight +" / "+ p1.bloodType);
		System.out.println(p2.name +" / "+ p2.height +" / "+ p2.weight +" / "+ p2.bloodType);
		System.out.println(p3.name +" / "+ p3.height +" / "+ p3.weight +" / "+ p3.bloodType);
		
	}

}
