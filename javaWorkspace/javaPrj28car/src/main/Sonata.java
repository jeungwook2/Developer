package main;

public class Sonata extends Car{

	@Override
	public void go() {
		System.out.println("소나타 출발 ~");
	}
	
	@Override
	public void stop() {
		System.out.println("소나타 멈춤 !");
	}
	
}
