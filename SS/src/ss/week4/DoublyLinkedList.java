package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
    	if (size == 0) {
    		head = new Node(element);
    		head.next = head;
    		head.previous = head;
    	} else if (index == 0) {
    		Node newNode = new Node(element);
    		Node h = head;
    		Node prevh = head.previous;
    		prevh.next = newNode;
    		newNode.previous = prevh;
    		h.previous = newNode;
    		newNode.next = h;
    		head = newNode;
     	} else if (index == size) {
    		Node newNode = new Node(element);
    		Node lastNode = head.previous;
    		lastNode.next = newNode;
    		head.previous = newNode;
    		newNode.next = head;
    		newNode.previous = lastNode;
    	} else {
    		Node indexnode = this.getNode(index);
    		Node beforeIndex = indexnode.previous;
    		Node newNode = new Node(element);
    		beforeIndex.next = newNode;
    		newNode.previous = beforeIndex;
    		indexnode.previous = newNode;
    		newNode.next = indexnode;
    	}
    	size = size + 1;    
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
    	if (index == 0 && size == 1) {
    		head = new Node(null);
    	} else if (index == 0) {
    		Node nextnode = head.next;
    		Node previousnode = head.previous;
    		head = nextnode;
    		head.next = nextnode.next;
    		head.previous = previousnode;
    	} else {
    		Node indexNode = getNode(index);
    		Node beforeIndex = indexNode.previous;
    		Node afterIndex = indexNode.next;
    		beforeIndex.next = afterIndex;
    		afterIndex.previous = beforeIndex;
    		indexNode.next = null;
    		indexNode.previous = null;
    	}
        size = size - 1;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        if (i != -1) {
        	pos = 0;
        }
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
