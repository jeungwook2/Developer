package main;

public class Main {

	public static void main(String[] args) {
		
		Pokemon[] pokemonArray = new Pokemon[2];

		pokemonArray[0] = new Pikachu();
		pokemonArray[1] = new Turtle();
		
		pokemonArray[0].name = "피카츄";
		pokemonArray[1].name = "꼬부기";
		
		pokemonArray[0].bodyAttack();
		pokemonArray[0].skill01();

		pokemonArray[1].bodyAttack();
		pokemonArray[1].skill01();
		
	}

}
