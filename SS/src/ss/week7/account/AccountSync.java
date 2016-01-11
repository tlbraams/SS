package ss.week7.account;

public class AccountSync {

	public static void main(String[] args) {
		Account account = new Account();
		Thread accountThread1 = new MyThread(1000.0, 10, account);
		Thread accountThread2 = new MyThread(-1000.0, 10, account);
		
		accountThread1.start();
		accountThread2.start();
		
		try {
			accountThread1.join();
			accountThread2.join();
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		
		System.out.println("The balance of the account is : " + account.getBalance());
		
		
	}
}
