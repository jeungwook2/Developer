package main;

public class Pikachu extends Pokemon{
	
	// 이 메서도는 부모한테 있는거 덮어쓰기 한거
	@Override
	public void skill01() {
		System.out.println("백만볼트 !!!");
	}
	
}
