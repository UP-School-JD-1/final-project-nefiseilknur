package Employee;

public class Worker {
	int workerId;

// Constructors
	public Worker() {
	}

	public Worker(int workerId) {
		this.workerId = workerId;
	}

//Getters and Setters
	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	@Override
	public String toString() {
		return "Worker's id =" + getWorkerId() + "]";
	}

}
