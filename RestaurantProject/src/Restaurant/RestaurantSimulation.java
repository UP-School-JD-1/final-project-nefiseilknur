package Restaurant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Employee.Chef;
import Employee.Waiter;
import Menu.Drink;
import Menu.Food;
import Menu.Order;

public class RestaurantSimulation {

	public static List<Customer> waitOrder;

	List<Customer> customerList = new ArrayList<>();
	List<Thread> tCustomerList = new ArrayList<>();
	List<Waiter> waiterList = new ArrayList<>();
	List<Thread> tWaiterList = new ArrayList<>();
	List<Chef> chefList = new ArrayList<>();
	List<Thread> tChefList = new ArrayList<>();
	Food food = new Food();
	Drink drink = new Drink();
	Customer customer;
	Thread tCustomer;
	Waiter waiter;
	Thread tWaiter;
	Chef chef;
	Thread tChef;
	int numberOfCustomer = 15;
	int numberOfChef = 2;
	int numberOfWaiter = 4;

	public void startsimulation() {
		waitOrder = new ArrayList<>();
		// Getting random customers
		for (int i = 1; i <= numberOfCustomer; i++) {
			LinkedList<Order> order = new LinkedList<Order>();
			order.add(food.getARandomFood());
			order.add(food.getARandomFood());
			order.add(drink.getARandomDrink());
			this.customer = new Customer(i, order);
			customerList.add(customer);
			this.tCustomer = new Thread(customer);
			tCustomerList.add(tCustomer);
			tCustomer.start();
		}
		// Getting random waiters
		for (int i = 1; i <= numberOfWaiter; i++) {
			this.waiter = new Waiter(i);
			waiterList.add(waiter);
			this.tWaiter = new Thread(waiter);
			tWaiterList.add(tWaiter);
			tWaiter.start();
		}
		// Getting random chefs
		for (int i = 1; i <= numberOfChef; i++) {
			this.chef = new Chef(i);
			chefList.add(chef);
			this.tChef = new Thread(chef);
			tChefList.add(tChef);
			tChef.start();
		}
	}

	// Getters an Setters
	public static List<Customer> getWaitOrder() {
		return waitOrder;
	}

	public static void setWaitOrder(List<Customer> waitOrder) {
		RestaurantSimulation.waitOrder = waitOrder;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Thread> gettCustomerList() {
		return tCustomerList;
	}

	public void settCustomerList(List<Thread> tCustomerList) {
		this.tCustomerList = tCustomerList;
	}

	public List<Waiter> getWaiterList() {
		return waiterList;
	}

	public void setWaiterList(List<Waiter> waiterList) {
		this.waiterList = waiterList;
	}

	public List<Thread> gettWaiterList() {
		return tWaiterList;
	}

	public void settWaiterList(List<Thread> tWaiterList) {
		this.tWaiterList = tWaiterList;
	}

	public List<Chef> getChefList() {
		return chefList;
	}

	public void setChefList(List<Chef> chefList) {
		this.chefList = chefList;
	}

	public List<Thread> gettChefList() {
		return tChefList;
	}

	public void settChefList(List<Thread> tChefList) {
		this.tChefList = tChefList;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Thread gettCustomer() {
		return tCustomer;
	}

	public void settCustomer(Thread tCustomer) {
		this.tCustomer = tCustomer;
	}

	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	public Thread gettWaiter() {
		return tWaiter;
	}

	public void settWaiter(Thread tWaiter) {
		this.tWaiter = tWaiter;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Thread gettChef() {
		return tChef;
	}

	public void settChef(Thread tChef) {
		this.tChef = tChef;
	}

	public int getNumberOfCustomer() {
		return numberOfCustomer;
	}

	public void setNumberOfCustomer(int numberOfCustomer) {
		this.numberOfCustomer = numberOfCustomer;
	}

	public int getNumberOfChef() {
		return numberOfChef;
	}

	public void setNumberOfChef(int numberOfChef) {
		this.numberOfChef = numberOfChef;
	}

	public int getNumberOfWaiter() {
		return numberOfWaiter;
	}

	public void setNumberOfWaiter(int numberOfWaiter) {
		this.numberOfWaiter = numberOfWaiter;
	}
}
