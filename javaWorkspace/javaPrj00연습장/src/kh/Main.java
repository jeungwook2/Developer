package kh;


public class Main {
	
    public static void main(String[] args) {

    	Animal dog = new Dog();
    	Animal cat = new Cat();
    	
    	dog.name = "강아지";
    	dog.age = 10;
    	
    	cat.name = "고영희";
    	cat.age = 5;
    	
    	System.out.println(dog.name);
    	System.out.println(dog.age);
    	dog.cry();
    	System.out.println("\n\n");

    	System.out.println(cat.name);
    	System.out.println(cat.age);
    	cat.cry();
    }
}
