package Menu;

public class Order {

	String name;
	int servingTimeMS;
	int cost;

	//Constructors
	public Order() {
	}
public Order(String name, int servingTimeMS, int cost) {
		this.name = name;
		this.servingTimeMS = servingTimeMS;
		this.cost = cost;
	}

	//Getter and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getServingTimeMS() {
		return servingTimeMS;
	}

	public void setServingTimeMS(int servingTimeMS) {
		this.servingTimeMS = servingTimeMS;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
    //To String 
	@Override
	public String toString() {
		return "Order [name=" + name + ", servingTimeMS=" + servingTimeMS + "]";
	}
}
