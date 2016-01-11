package ss.week7.account;

public class MyThread extends Thread {

	private Account theAccount;
	private int theFrequency;
	private double theAmount;
	
	public MyThread(double amount, int frequency, Account account) {
		this.theAmount = amount;
		this.theFrequency = frequency;
		this.theAccount = account;
	}
	
	public void run() {
		for (int i = 0; i < theFrequency; i++) {
			theAccount.transaction(theAmount);
		}
	}
}
