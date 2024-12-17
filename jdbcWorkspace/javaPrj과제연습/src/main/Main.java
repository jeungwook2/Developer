package main;

import player.PlayerController;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== Player DB =====");
		
		
		PlayerController pc = new PlayerController();
		while(true) {
			pc.menu();
		}
	}

}
