package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
    	if (list.size() > 1) {
    		List<Elem> leftlist = list.subList(0, list.size() / 2);
    		List<Elem> rightlist = list.subList((list.size() / 2) + 1, list.size() - 1);
    		mergesort(leftlist);
    		mergesort(rightlist);
    		merge(leftlist, rightlist, list);
    	}
    }
    
    public static <Elem extends Comparable<Elem>> void merge(List<Elem> leftlist,
    				List<Elem> rightlist, List<Elem> list) {
    	int i = 0, j = 0;
    	int index = 0;
    	while (i < leftlist.size() && j < rightlist.size()) {
    		if (leftlist.get(i).compareTo(rightlist.get(j)) <= 0) {
    			list.set(index, leftlist.get(i));
    			i++; index++;
    		} else if (leftlist.get(i).compareTo(rightlist.get(j)) > 0) {
    			list.set(index, rightlist.get(j));
    			j++; index++;
    		}
    	}
    	while (i < leftlist.size()) {
    		list.set(index, leftlist.get(i));
    		i++; index++;
    	}
    	while (j < rightlist.size()) {
    		list.set(index, rightlist.get(j));
    		j++; index++;
    	}
    }
}
