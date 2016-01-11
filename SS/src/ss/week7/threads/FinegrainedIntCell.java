package ss.week7.threads;

import java.util.concurrent.locks.*;

public class FinegrainedIntCell implements IntCell {

	private final Lock lock = new ReentrantLock();
	private final Condition notRead = lock.newCondition();
	private final Condition notWritten = lock.newCondition();
	private boolean consumed = true;
	private int value = 0;
	
	
	@Override
	public void setValue(int val) {
		lock.lock();
		try {
			while (!consumed) {
				notWritten.await();
			}
			value = val;
			consumed = false;
			notRead.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	@Override
	public int getValue() {
		int result = 0;
		lock.lock();
		try {
			while (consumed) {
				notWritten.await();
			}
			result = value;
			consumed = true;
			notWritten.signal();
		} catch (InterruptedException e) {
			System.err.println(e);
		} finally {
			lock.unlock();
		}
		return result;
	}

}
