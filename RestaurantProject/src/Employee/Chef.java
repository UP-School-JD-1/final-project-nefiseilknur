package Employee;

import Restaurant.Customer;

public class Chef extends Worker implements Runnable {

	Customer customer;

//Constructors
	public Chef() {
	}

	public Chef(int id) {
		super(id);
	}

//Methods	
	public synchronized void chefIsReady() {
		System.out.println("The chef " + this.getWorkerId() + " ready to cook.");
	}

	public synchronized void chefStartedToCook(Customer customer) {
		System.out.println("The chef " + this.getWorkerId() + " started to cook " + customer.order + " for customer "
				+ customer.getId() + ".");
	}

	public synchronized void chefFinishedToCook(Customer customer) {
		System.out.println("The chef " + this.getWorkerId() + " finished to cook " + customer.order + " for customer "
				+ customer.getId() + ".");
	}

	@Override
	public void run() {
		this.chefIsReady();
	}
}
