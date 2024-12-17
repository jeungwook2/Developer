package main;

import game.GameManager;
import mob.Pokemon;

public class Main {

	public static Pokemon userPokemon;
	public static Pokemon comPokemon;


	public static void main(String[] args) {
		
		System.out.println("===== 포켓몬 =====");
		
		GameManager gm = new GameManager();
		gm.selectPokemon();
		
		while(true) {
			gm.battle(userPokemon, comPokemon);
			if(comPokemon.getHp() <= 0) {
				break;
			}
			gm.battle(comPokemon, userPokemon);
			if(userPokemon.getHp() <= 0) {
				break;
			}
		}

	}//main

}//class