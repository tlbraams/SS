package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {

	private int value;
	private boolean newData;
	
	public SynchronizedIntCell() {
		value = 0;
		newData = false;
	}
	
	@Override
	public void setValue(int val) {
		synchronized (this) {
			while (newData) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			value = val;
			newData = true;
			this.notifyAll();
		}

	}

	@Override
	public int getValue() {
		int result;
		synchronized (this) {
			while (!newData) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			result = value;
			newData = false;
			this.notifyAll();
		}
		return result;
	}

}
