package ss.week7.threads;

public class TestConsole extends Thread {
	

	public TestConsole(String name) {
		super(name);
	}
	
	public void run() {
		sum();
	}
	
	private void sum() {
		int readone = Console.readInt(this.getName() + ": Get number 1?");
		int readtwo = Console.readInt(this.getName() + ": Get number 2?");
		Console.println(this.getName() + ": "
							+ readone + " + " + readtwo + " = " + (readone + readtwo));
	}
	
	public static void main(String[] args) {
		(new TestConsole("Thread A")).start();
		(new TestConsole("Thread B")).start();
	}
}
