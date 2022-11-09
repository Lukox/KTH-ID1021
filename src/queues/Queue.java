package queues;

import java.util.Iterator;

public class Queue {
	Node head;
	Node last;
	public class Node {
		public Integer item;
		public Node tail;
		public Node(Integer item, Node list) {
			this.item = item;
			this.tail = list;
		}
	}
	public Queue() {
		this.head = null;
		this.last = null;
	}
	
	public void add(Integer item) {
		Node node = last;
		if(last == null) {
			this.head = new Node(item, null);
			this.last = head;
		}else {
			node.tail = new Node(item, null);
			this.last = node.tail;
		}
	}
	
	public Integer remove() {
		Node node = head;
		Integer removedNode = null;
		if(node != null ) {
			removedNode = node.item;
			node = node.tail;
			this.head = node;
			if(head == null) {
				this.last = null;
			}
		}
		return removedNode;
	}

}
