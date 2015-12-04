package ss.week4;

public class LinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node first;

    public LinkedList() {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index - 1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
    	if (first.getElement().equals(element)) {
    		Node nextNode = first.next;
    		first = nextNode;
    	} else {
    		Node before = findBefore(element);
    		Node nextNode = before.next.next;
    		before.next = nextNode;
    	}
    	size = size - 1;
    }

    public Node findBefore(Element element) {
    	Node result = null;
    	for (int i = 1; i < size; i++) {
    		if (getNode(i).getElement().equals(element))	{
    			result = getNode(i - 1);
    		}
    	}
        return result;
    }

    //@ requires 0 <= index && index < this.size();
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
