package game;

import java.util.Scanner;

import main.Main;
//import mob.Lizard;
//import mob.Pikachu;
//import mob.Turtle;
import mob.*;

public class GameManager {

	private Scanner sc;
	
	public GameManager() {
		this.sc = new Scanner(System.in);
	}
	
	// 포켓몬 선택 (나, 컴퓨터)
	public void selectPokemon() {
		
		System.out.println("----- 포켓몬 선택 -----");
		System.out.println("1. 피카츄");
		System.out.println("2. 파이리");
		System.out.println("3. 꼬부기");
		System.out.print("포켓몬 번호 : ");
		String num = sc.nextLine();
		switch(num) {
		case "1" : Main.userPokemon = new Pikachu(100, 20); break;
		case "2" : Main.userPokemon = new Lizard(90, 25); break;
		case "3" : Main.userPokemon = new Turtle(110, 15); break;
		}
		
		int random = (int)(Math.random() * 3) + 1;
		switch(random) {
		case 1 : Main.comPokemon = new Pikachu(100, 20); break;
		case 2 : Main.comPokemon = new Lizard(90, 25); break;
		case 3 : Main.comPokemon = new Turtle(110, 15); break;
		}
		
	}
	
	
	// 배틀
	public void battle(Pokemon attacker, Pokemon defender) {
		System.out.println("----- battle -----");
		
//		Pokemon attacker = Main.userPokemon;
//		Pokemon defender = Main.comPokemon;
		
		// 포켓몬 행동
		System.out.println("1. 기본공격 (몸통박치기)");
		System.out.println("2. 스킬공격");
		System.out.print("번호 입력 : ");
		String num = sc.nextLine();
		
		if(num.equals("1")) {
			attacker.bodyAttack();
		}else {
			attacker.skill();
		}
		
		int a = defender.getHp();
		int b = attacker.getAtk();
		int dmg = num.equals("1") ? b : b * 2;
		defender.setHp(a - dmg);

		System.out.println(defender.getName() + "은" + dmg + "의 피해를 입었다.");
		System.out.println("남은체력 : " + defender.getHp());
		
		if(defender.getHp() <= 0) {
			System.out.println(defender.getName() + " 사망...");
			System.out.println(attacker.getName() + " 승리 !");
		}
	}
}
