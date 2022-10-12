package Restaurant;

import java.util.List;

import Menu.Order;

public class Customer implements Runnable {

	public int id;
	public List<Order> order;
	Object lock = new Object();
	RestaurantSimulation restaurant = new RestaurantSimulation();
	public static int tableNum = 10;
	private static int cusCounter = 0;

	// Constructors
	public Customer() {
	}

	public Customer(int id, List<Order> order) {
		this.id = id++;
		this.order = order;
	}

	// methods

	public synchronized void customerMakeReservation(Customer customer) throws InterruptedException {

		System.out.println("The customer " + id + " made a reservation.");
	}

	public synchronized void customerEntered(Customer customer) {
		System.out.println("The customer " + id + " entered the resaturant.");
	}

	public synchronized void customerIsWaiting(Customer customer) {
		System.out.println("The customer " + id + " is  waiting.");
	}

	public synchronized void customerPlacedOrder(Customer customer) {
		System.out.println("The customer " + id + " ordered " + order + ".");

	}

	public synchronized void customerReceivedOrder(Customer customer) {
		System.out.println("The customer " + id + " recieved order  " + order+ ".");
	}

	public synchronized void customerLeavingRestaurant(Customer customer) throws InterruptedException {
		System.out.println("The customer " + id + " is leaving restaurant.");
	}

	@Override
	public void run() {
		try {
			this.customerMakeReservation(this);
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		synchronized (lock) {
			while (cusCounter >= tableNum) {
				try {
					this.customerIsWaiting(this);
					lock.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			cusCounter++;

			try {
				this.customerEntered(this);
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			synchronized (RestaurantSimulation.waitOrder) {

				try {
					this.customerPlacedOrder(this);
					Thread.sleep(500);
					RestaurantSimulation.waitOrder.add(this);
					RestaurantSimulation.waitOrder.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			synchronized (this) {
				try {
					this.wait();
					this.customerReceivedOrder(this);
					Thread.sleep(1000); // Eating time
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				this.customerLeavingRestaurant(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock) {
				cusCounter--;
				lock.notify();
			}
		}
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public static int getTableNum() {
		return tableNum;
	}

	public static void setTableNum(int tableNum) {
		Customer.tableNum = tableNum;
	}

	// To string
	@Override
	public String toString() {
		return "Customer id= " + id + ", Order= " + order + "]";
	}
}