package Linked;

public class LinkedList {
	int head;
	LinkedList tail;

	public LinkedList(int item, LinkedList list) {
		head = item;
		tail = list;
	}

	public int head() {
		return this.head;
	}
	public LinkedList tail() {
		return this.tail;
	}

	public void push(LinkedList b) {
		LinkedList nxt = this;
		while (nxt.tail != null) {
			nxt = nxt.tail;
		}
		nxt.tail = b;
	}
	
	public int pop() {
		LinkedList nxt = this;
		if (nxt.tail != null){
			while (nxt.tail.tail != null) {
				nxt = nxt.tail;
			}
			int temp = nxt.tail.head;
			nxt.tail = null;
			return temp;
		}
		int temp = nxt.head;
		this.tail = null;
		return temp;
	}

}
