package ss.week7;

public class ConcatThread extends Thread {
    private static String text = ""; // global variable
    private String toe;

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public void run() {
    	synchronized (text) {
    		text = text.concat(toe);
    	}
    }

    public static void main(String[] args) {
    	Thread one = new ConcatThread("one;");
    	Thread two = new ConcatThread("two;");
        one.start();
        two.start();
        
        try {
        	one.join();
        	two.join();
        } catch (InterruptedException e) {
        	System.err.println(e.getMessage());
        }
        System.out.println(text);
    }
}
