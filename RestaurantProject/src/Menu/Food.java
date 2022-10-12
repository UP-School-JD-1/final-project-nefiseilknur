package Menu;

import java.util.Random;

public class Food extends Order {
//Constructors
	public Food() {
		super();
	}

	public Food(String name, int servingTimeMS, int cost) {
		super(name, servingTimeMS, cost);
	}

//Getting a random food 
	public Food getARandomFood() {

		Random random = new Random();
		int i = random.nextInt(6);

		Food food = null;
		switch (i) {
		case 0:
			food = new Food("mushroom pizza", 450, 6);
			break;
		case 1:
			food = new Food("margherita pizza", 350, 5);
			break;
		case 2:
			food = new Food("chicken pizza", 500, 8);
			break;
		case 3:
			food = new Food("fries", 300, 3);
			break;
		case 4:
			food = new Food("wings", 300, 4);
			break;
		case 5:
			food = new Food("salad", 200, 5);
			break;
		}
		return food;
	}

//To String
	@Override
	public String toString() {
		return this.getName();
	}
}