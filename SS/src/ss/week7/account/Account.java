package ss.week7.account;

public class Account {
	protected double balance = 0.0;

	public synchronized void transaction(double amount) {
		try {
			if (balance + amount < -1000.0) {
				this.wait();
			}
			balance = balance + amount;
			notify();
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
	
	public double getBalance() {
		return balance;

	}
}
