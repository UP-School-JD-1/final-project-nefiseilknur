package Menu;

import java.util.Random;

public class Drink extends Order {
//Constructors
	public Drink() {
		super();
	}

	public Drink(String name, int servingTimeMS, int cost) {
		super(name, servingTimeMS, cost);
	}

//Getting a random drink
	public Drink getARandomDrink() {

		Random random = new Random();
		int i = random.nextInt(5);

		Drink drink = null;
		switch (i) {
		case 0:
			drink = new Drink("orange juice", 14, 3);
			break;
		case 1:
			drink = new Drink("lemonade", 15, 4);
			break;
		case 2:
			drink = new Drink("tea", 16, 2);
			break;
		case 3:
			drink = new Drink("coffee", 19, 4);
			break;
		case 4:
			drink = new Drink("water", 8, 1);
			break;
		}
		return drink;
	}

// To string
	@Override
	public String toString() {
		return getName();
	}
}
