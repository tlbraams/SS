package ss.week7;


public class QuickSort implements Runnable {
	
	private int[] toSort;
	private int first;
	private int last;
	
	public QuickSort(int[] a, int first, int last) {
		this.toSort = a;
		this.first = first;
		this.last = last;
	}
	
    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }
    public static void qsort(int[] a, int first, int last) {
        if (first < last) {
            int position = partition(a, first, last);
            Thread one = new Thread(new QuickSort(a, first, position - 1));
            Thread two = new Thread(new QuickSort(a, position + 1, last));
            one.start();
            two.start();
            try {
            	one.join();
            	two.join();
            } catch (InterruptedException e) {
            	System.err.println(e);
            }
        }
    }
    public static int partition(int[] a, int first, int last) {

        int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last); // put pivot at the end of the array
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last); // put pivot in its place "in the middle"
        return pi;
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
	@Override
	public void run() {
		qsort(toSort, first, last);
	}

}
