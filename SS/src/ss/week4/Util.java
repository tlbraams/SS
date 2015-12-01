package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static <Element> List<Element> zip(List<Element> l1, List<Element> l2) {
        ArrayList<Element> result = new ArrayList<Element>();
        for (int i = 0; i < l1.size(); i++) {
            result.add(l1.get(i));
            result.add(l2.get(i));
        }
        return result;
    }    

    /**
     * signum function.
     * @param i the function argument
     * @return -1, 0 or 1 if the argument is negative, 0 or positive
     */
    public static int signum(int i) {
    	int j;
        if (i < 0) {
            j = -1;
        } else if (i > 0) {
            j = 1;
        } else {
            j = 0;
        }
        return j;
    }
}
