package Employee;

import Restaurant.Customer;
import Restaurant.RestaurantSimulation;

public class Waiter extends Worker implements Runnable {
	Chef chef;
	Customer customer;
	RestaurantSimulation restaurant = new RestaurantSimulation();

	// Constructors
	public Waiter() {
	}

	public Waiter(int id) {
		super(id);
	}

	// Methods

	public synchronized void waiterIsReady() {

		System.out.println("The waiter " + getWorkerId() + " ready to service.");

	}

	public synchronized void waiterInformChef(Customer customer) {

		System.out.println("The waiter " + this.workerId + " inform the chef about customer " + customer.getId()
				+ "'s order " + customer.order + ".");
	}

	public synchronized void waiterServedOrder(Customer customer) {

		System.out.println("The waiter " + this.workerId + " served customer " + customer.getId() + "'s order "
				+ customer.order + ".");
	}

	@Override
	public void run() {
		Customer customer;
		
		try {
			this.waiterIsReady();
			while (true) {

				synchronized (RestaurantSimulation.waitOrder) {
					while (RestaurantSimulation.waitOrder.isEmpty()) {
						RestaurantSimulation.waitOrder.wait();
					}
					customer = RestaurantSimulation.waitOrder.remove(0);
					RestaurantSimulation.waitOrder.notifyAll();
				}

				if (customer != null) {
					synchronized (customer) {
						this.waiterInformChef(customer);
						System.out.println("The chef  started to cook " + customer.order + " for customer "
								+ customer.getId() + ".");
						Thread.sleep(1000);
						System.out.println("The chef finished to cook " + customer.order + " for customer "
								+ customer.getId() + "");
						this.waiterServedOrder(customer);
						customer.notifyAll();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
