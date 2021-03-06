package lab10.prob6;

import java.util.Iterator;

//Show the methods are not threadsafe.
//Then modify so that they are threadsafe.
public class Queue {
	
	class Node {
		Object value;
		Node next;
	}
	private Node head;
	private Node tail;
	
	synchronized public void add(Object newValue) {
		Node n = new Node();
		if(head == null) head = n;
		else tail.next = n;
		tail = n;
		tail.value = newValue;
		count();
	}
	public Object remove() {
		if(head == null) return null;
		Node n = head;
		head = n.next;
		return n.value;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Queue queue = new Queue();
		
		Runnable r = () -> {
			for (int i = 0; i < 1000; i++) {
				queue.add("Item" + i);
			}
		};

		for (int i = 0; i < 10; i++) {
			new Thread(r).start();
		}

		
		
		Thread.sleep(5000);
		System.out.println(queue.count()); // expected 10000		
	}
	
	public int count() {
		int counter = 0;
		Node node = head;
	
		while (node != null) {
			counter++;
			node = node.next;
		}

		return counter;
	}
}
