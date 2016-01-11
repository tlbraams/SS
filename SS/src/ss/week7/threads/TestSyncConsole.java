package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	
	private static final ReentrantLock LOCK = new ReentrantLock();
	private static SyncConsole sc;

	public TestSyncConsole(String name) {
		super(name);
	}
	
	public void run() {
		sum();
	}
	
	private void sum() {
		synchronized (sc) {
			int readone = SyncConsole.readInt(this.getName() + ": Get number 1?");
			int readtwo = SyncConsole.readInt(this.getName() + ": Get number 2?");
			SyncConsole.println(this.getName() + ": "
								+ readone + " + " + readtwo + " = " + (readone + readtwo));
		}
		LOCK.lock();
		try {
			int readone = SyncConsole.readInt(this.getName() + ": Get number 1?");
			int readtwo = SyncConsole.readInt(this.getName() + ": Get number 2?");
			SyncConsole.println(this.getName() + ": "
								+ readone + " + " + readtwo + " = " + (readone + readtwo));
			
		} finally {
			LOCK.unlock();
		}
	}
	
	public static void main(String[] args) {
		sc = new SyncConsole();
		(new TestSyncConsole("Thread A")).start();
		(new TestSyncConsole("Thread B")).start();
	}
}
